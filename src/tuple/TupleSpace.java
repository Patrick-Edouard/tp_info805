package tuple;
import java.util.ArrayList;

import java.util.HashMap;


public class TupleSpace {
	
	private static TupleSpace instance;
	private ArrayList<Tuple> allTuples;
	
	private TupleSpace(){
		
	}
	
	public static TupleSpace getInstance(){
		if(instance == null)
			instance = new TupleSpace();
		return instance;
	}

	public ArrayList<Tuple> getAllTuples() {
		return allTuples;
	}

	public void setAllTuples(ArrayList<Tuple> allTuples) {
		this.allTuples = allTuples;
	}
	
	/**
	 * Retourne si un tuple va bien & le retire
	 * Sinon retourne null
	 * @param template
	 * @return
	 */
	public Tuple in(HashMap<String,String> template){
		
		for(Tuple t : this.allTuples){
			if(t.equals(template)){
				this.allTuples.remove(t);
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Retourne si un tuple va bien
	 * Sinon retourne null
	 * @param template
	 * @return
	 */
	public Tuple rd(HashMap<String,String> template){
		
		for(Tuple t : this.allTuples){
			if(t.equals(template)){
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Retourne si un tuple va bien
	 * Sinon retourne null
	 * @param template
	 * @return
	 */
	public void out(HashMap<String,String> template){
		
		this.allTuples.add(new Tuple(template));
		
	}
	
	public static void main (String [] args){
		Tuple ts1 = new Tuple();
		Tuple ts2 = new Tuple();
		ts1.addField("requirements", "String");
		ts1.addField("cost", "Integer");
		ts1.addField("time", "Integer");
		ts1.addField("quantity", "Integer");
		
		ts2.addField("requirements", "String");
		ts2.addField("cost", "Integer");
		ts2.addField("time", "Integer");
		ts2.addField("quantity", "Integer");
		
		System.out.println(ts2.equals(ts1.getTemplate()));
		
		System.out.println(ts1.toString());
		
	}
}
