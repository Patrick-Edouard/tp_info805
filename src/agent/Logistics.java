package agent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import tuple.Tuple;
import tuple.TupleSpace;

public class Logistics extends Agent implements ActionListener, Runnable{
	
	private TupleSpace tupleSpace = TupleSpace.getInstance();
	private ArrayList<Supplier> suppliers;
    private ArrayList<Tuple> reponses;
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

    private void waitForSupplier(){

        HashMap template = new HashMap();
        template.put("idsupplier","String");
        template.put("requierements", "String");
        template.put("cost", "String");
        template.put("time", "String");
        template.put("quantity", "String");


        Thread tWaiter = new Thread(new TupleWaiter(this, template));
        tWaiter.start();

    }

    void tupleFound(ArrayList<Tuple> tuples){
        reponses = tuples;
        this.view.displayResponse(tuples);
    }

    private void broadcastCustomerRequest(){
        //Adapte le tuple
        customerRequest.addField("idrequete",""+NB_REQUEST);
        this.tupleSpace.out(customerRequest);

        //Après broadcast attend une réponse
        this.waitForSupplier();
    }

    private void sendResponsesToCustomer(){
        for(Tuple tuple  : reponses){
            tupleSpace.out(tuple);
        }

        Tuple t = new Tuple();
        t.addField("Synchronize","logisticReponse");

        tupleSpace.out(t);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.buttonSend)){
            this.broadcastCustomerRequest();
        }else if(e.getSource().equals(view.buttonSendResponse)){
            this.sendResponsesToCustomer();
        }
    }

    @Override
    public void run() {
        this.waitForClient();
    }
}
