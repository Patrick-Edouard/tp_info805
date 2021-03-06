package tuple;
import java.util.ArrayList;

import java.util.HashMap;


public class TupleSpace {
	
	private static TupleSpace instance;
	private ArrayList<Tuple> allTuples;
	
	private TupleSpace(){
		this.allTuples = new ArrayList<Tuple>();
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
     * Appel bloquant
     * @param template
     * @return
     */
    public Tuple in(HashMap<String,String> template){
        while(true){
            synchronized (this){
                for(Tuple t : this.allTuples){
                    if(t.isTemplate(template)){
                        this.allTuples.remove(t);
                        return t;
                    }
                }
            }
        }

        // bloquant ?
    }

    /**
     * Read bloquant
     * @param template
     * @return
     */
    public Tuple rdb(HashMap<String, String> template){
        while(true){
            synchronized (this){
                for(Tuple t : this.allTuples){
                    if(t.isTemplate(template)){
                        return t;
                    }
                }
            }
        }
    }

    /**
     * Retourne si un tuple va bien
     * Sinon retourne null
     * @param template
     * @return
     */
    public Tuple rd(HashMap<String,String> template){
        synchronized (this){
            for(Tuple t : this.allTuples){
                if(t.isTemplate(template)){
                    return t;
                }
            }
            return null;
        }
    }

    /**
     * Retourne si un tuple va bien
     * Sinon retourne null
     * @param template
     * @return
     */
    public ArrayList<Tuple> inAll(HashMap<String, String> template){
        ArrayList<Tuple> matches = new ArrayList<Tuple>();
        synchronized (this){
            for(Tuple t : this.allTuples){
                if(t.isTemplate(template)){
                    matches.add(t);
                }
            }
            for(Tuple t : matches){
                this.allTuples.remove(t);
            }
            return matches;
        }
    }
	
	/**
	 * Ajoute un tuple à l'espace de tuples
	 * @param t
	 * @return
	 */
	public void out(Tuple t){
        synchronized (this){
            this.allTuples.add(t);
            this.displayTupleSpace();
        }
	}

    public void displayTupleSpace(){
        System.out.println("\n[TuppleSpace Display]" +
                "\n" +
                "\nContenue :");

        for(Tuple t : this.allTuples){
            System.out.print(t);
        }
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
