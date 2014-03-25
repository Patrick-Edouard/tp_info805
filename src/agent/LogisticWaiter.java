package agent;

import tuple.Tuple;
import tuple.TupleSpace;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by patrick-edouard on 3/25/14.
 */
public class LogisticWaiter implements Runnable {
    TupleSpace tupleSpace = TupleSpace.getInstance();
    Logistics parent;

    LogisticWaiter(Logistics parent){
        this.parent = parent;
    }

    @Override
    public void run() {

        HashMap template = new HashMap();
        template.put("idsupplier","String");
        template.put("requierements", "String");
        template.put("cost", "String");
        template.put("time", "String");
        template.put("quantity", "String");

        ArrayList<Tuple> reponses = new ArrayList<Tuple>();

        try {
            new Thread(this).sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Foirage du timer");
        }

        this.parent.waiterResponse(this.tupleSpace.rdAll(template));

    }
}
