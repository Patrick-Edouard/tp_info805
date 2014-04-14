package agent;

import tuple.Tuple;
import tuple.TupleSpace;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by patrick-edouard on 4/14/14.
 */
public class SingleTupleWaiter implements Runnable{

    private TupleSpace tupleSpace = TupleSpace.getInstance();
    private Agent caller;
    private HashMap template;
    public SingleTupleWaiter(Agent caller,HashMap template){
        this.caller = caller;
        this.template = template;
    }

    public void run(){

        this.caller.singleTupleFound(this.tupleSpace.rdb(template));

    }
}
