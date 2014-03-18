package agent;

import java.util.ArrayList;
import java.util.HashMap;

import tuple.TupleSpace;

public class Logitics {
	
	private TupleSpace tupleSpace = TupleSpace.getInstance();
	private ArrayList<Supplier> suppliers;
	
	public Logitics(){
		this.waitForClient();
	}
	
	private void waitForClient(){
        System.out.println("En attente du customer");
        HashMap template = new HashMap();
        template.put("String", "requierements");
        template.put("String", "cost");
        template.put("String", "time");
        template.put("String", "quantity");
        System.out.print("Demande de client lue :\n"+tupleSpace.in(template));
    }

}
