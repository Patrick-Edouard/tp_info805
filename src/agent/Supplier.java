package agent;

import tuple.Tuple;
import tuple.TupleSpace;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Supplier extends Agent implements ActionListener, Runnable{

    private int idSupplier = ID++;
    private static int ID = 1;
	private TupleSpace tupleSpace = TupleSpace.getInstance();
    private DialogueSupplier view;
    private Tuple customerRequest;

    public Supplier(){
        this.view = new DialogueSupplier(this);
    }

    private void waitBroadcast(){
        HashMap template = new HashMap();
        template.put("requierements", "String");
        template.put("cost", "String");
        template.put("time", "String");
        template.put("quantity", "String");
        template.put("idrequete", "String");
        this.customerRequest=this.tupleSpace.rdb(template);
        this.view.requestReceived(customerRequest);
    }

    private void sendOffer(){
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("idsupplier", idSupplier+"");
        data.put("requierements",this.view.getRequierement() );
        data.put("cost",this.view.getcost());
        data.put("time",this.view.getTime());
        data.put("quantity",this.view.getQuantity());
        this.tupleSpace.out(new Tuple(data));

        this.waitResponse();
    }

    private void waitResponse(){
        HashMap template = new HashMap();

        template.put("idSupplier","String");

        Thread thread = new Thread(new SingleTupleWaiter(this, template));
        thread.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.view.buttonSend)){
            this.sendOffer();
        }
    }

    @Override
    public void run() {
        this.waitBroadcast();
    }

    @Override
    void tupleFound(ArrayList<Tuple> tuples) {

    }

    @Override
    void singleTupleFound(Tuple tuple) {

        if(!(tuple.getValue("idSupplier").equals(this.idSupplier+""))){

            this.view.getContentPane().removeAll();
            this.view.textRequierement.setText("Your offer hasn't be choosen. This window will exit");
            this.view.add(this.view.textRequierement);
            this.view.setBackground(Color.RED);
            this.view.revalidate();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.view.dispose();
        }
        else{
            this.view.chosenOne();
        }
    }
}
