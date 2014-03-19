package agent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import tuple.Tuple;
import tuple.TupleSpace;

public class Logistics implements ActionListener, Runnable{
	
	private TupleSpace tupleSpace = TupleSpace.getInstance();
	private ArrayList<Supplier> suppliers;
    private DialogueLogistics view;
    private Tuple customerRequest= new Tuple();
    private static int NB_REQUEST=0;
	
	public Logistics(){
        view = new DialogueLogistics(this);
	}
	
	private void waitForClient(){
        System.out.println("En attente du customer");
        HashMap template = new HashMap();
        template.put("requierements", "String");
        //type des données ?
        template.put("cost", "String");
        template.put("time", "String");
        template.put("quantity", "String");

        this.customerRequest=this.tupleSpace.in(template);

        this.view.displayCustomerRequest(customerRequest);

        System.out.print("Demande de client lue :\n"+customerRequest);
    }

    private void broadcastCustomerRequest(){
        //Adapte le tuple
        customerRequest.addField("idrequete",""+NB_REQUEST);

        this.tupleSpace.out(customerRequest);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.buttonSend)){
            this.broadcastCustomerRequest();
        }
    }

    @Override
    public void run() {
        this.waitForClient();
    }
}
