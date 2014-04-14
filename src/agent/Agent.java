package agent;

import tuple.Tuple;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by patrick-edouard on 3/28/14.
 */
public abstract class Agent {

    abstract void tupleFound(ArrayList<Tuple> tuples);
    abstract void singleTupleFound(Tuple tuple);
}
