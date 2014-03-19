package agent;

import tuple.Tuple;
import tuple.TupleSpace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Supplier implements ActionListener, Runnable{
	
	private TupleSpace tupleSpace = TupleSpace.getInstance();
    private DialogueSupplier view;
    private Tuple customerRequest;

    public Supplier(){
        this.view = new DialogueSupplier(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.view)){

        }
    }

    @Override
    public void run() {
        this.waitBroadcast();
    }
}
