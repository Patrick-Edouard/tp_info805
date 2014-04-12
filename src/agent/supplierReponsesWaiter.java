package agent;

import tuple.TupleSpace;

import java.util.HashMap;

/**
 * Created by patrick-edouard on 4/12/14.
 */
public class supplierReponsesWaiter implements Runnable {

    private Customer parent;
    private TupleSpace tupleSpace = TupleSpace.getInstance();

    public supplierReponsesWaiter(Customer parent){
       this.parent=parent;
    }

    @Override
    public void run() {
        HashMap template = new HashMap();

        template.put("Synchronize","String");

        this.tupleSpace.in(template);

        template = new HashMap();

        template.put("idsupplier","String");
        template.put("requierements", "String");
        template.put("cost", "String");
        template.put("time", "String");
        template.put("quantity", "String");

        parent.responseFromWaiter(tupleSpace.inAll(template));
    }
}
