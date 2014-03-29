package agent;


import tuple.Tuple;
import tuple.TupleSpace;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Observes the tuplespace while the template does match with a tupple. Then return it to the agent.
 * Created by patrick-edouard on 3/28/14.
 */
public class TupleWaiter implements Runnable{

    private TupleSpace tupleSpace = TupleSpace.getInstance();
    private Agent caller;
    private HashMap template;
    private int timer = 5000;
    public TupleWaiter(Agent caller,HashMap template){
        this.caller = caller;
        this.template = template;
    }

    public void setTimer(int timer){
        this.timer = timer;
    }

    public void run(){
        ArrayList<Tuple> reponses = new ArrayList<Tuple>();

        try {
            new Thread(this).sleep(timer);
        } catch (InterruptedException e) {
            System.err.println("Foirage du timer");
        }

        this.caller.tupleFound(this.tupleSpace.inAll(template));

    }
}
