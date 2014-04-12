package agent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import tuple.Tuple;
import tuple.TupleSpace;

public class Customer extends Agent implements Runnable, ActionListener{

	private String requierements = "";
	private String cost = "";
	private String time = "";
	private String quantity = "";
	private TupleSpace tupleSpace = TupleSpace.getInstance();
    private DialogueCustomer view;
	
	public Customer(){

	}
	
	private void sendToLogistics(){
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("requierements",this.requierements );
		data.put("cost",this.cost);
		data.put("time",this.time);
		data.put("quantity",this.quantity);
		this.tupleSpace.out(new Tuple(data));
        this.waitResponse();
	}

    private void retriewInfoFromView(){
        this.requierements=this.view.getRequierement();
        this.cost=this.view.getcost();
        this.time=this.view.getTime();
        this.quantity=this.view.getQuantity();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.view.buttonSend)){
            this.retriewInfoFromView();
            this.sendToLogistics();
        }
    }

    @Override
    public void run() {
        this.view = new DialogueCustomer(this);
    }

    @Override
    void tupleFound(ArrayList<Tuple> tuples) {

    }

    private void waitResponse(){

        Thread tCustomer = new Thread(new supplierReponsesWaiter(this));
        tCustomer.start();

    }

    public void responseFromWaiter(ArrayList<Tuple> tuples){
        this.view.displaySupplierChoice(tuples);
    }
}
