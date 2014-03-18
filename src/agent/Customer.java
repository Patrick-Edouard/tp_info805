package agent;

import java.util.HashMap;

import tuple.TupleSpace;

public class Customer {

	private String requierements;
	private String cost;
	private String time;
	private String quantity;
	private TupleSpace tupleSpace = TupleSpace.getInstance();
	
	public Customer(){
		
	}
	
	private void sendToLogistics(){
		HashMap<String, String> data = new HashMap<String, String>();
		data.put(this.requierements, "String");
		data.put(this.cost, "String");
		data.put(this.time, "String");
		data.put(this.quantity, "String");
		this.tupleSpace.out(data);
	}
	
}
