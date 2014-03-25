package agent;

import tuple.Tuple;
import tuple.TupleSpace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Supplier implements ActionListener, Runnable{

    private int idSupplier;
    private static int ID = 0;
	private TupleSpace tupleSpace = TupleSpace.getInstance();
    private DialogueSupplier view;
    private Tuple customerRequest;

    public Supplier(){
        this.view = new DialogueSupplier(this);
        idSupplier = ++ID;
    }

    private void waitBroadcast(){
        System.out.println("En attente d'un broadcast");
        HashMap template = new HashMap();
        template.put("requierements", "String");
        template.put("cost", "String");
        template.put("time", "String");
        template.put("quantity", "String");
        template.put("idrequete", "String");
        this.customerRequest=this.tupleSpace.in(template);
        this.view.requestReceived(customerRequest);
        System.out.println(customerRequest);
    }

    private void sendOffer(){
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("idsupplier", idSupplier+"");
        data.put("requierements",this.view.getRequierement() );
        data.put("cost",this.view.getcost());
        data.put("time",this.view.getTime());
        data.put("quantity",this.view.getQuantity());
        this.tupleSpace.out(new Tuple(data));
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
}
