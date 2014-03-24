package system;

import agent.Customer;
import agent.Logistics;
import agent.Supplier;

/**
 * Created by patrick-edouard on 3/18/14.
 */
public class Manager {

    public static void main(String[] args){
        new Customer();

         // à mettre dans un thread à cause de l'attente active
         // Argument à supplier pour préremplir en fonctions de ses capacitées
        Thread tSupplier = new Thread(new Supplier());
        tSupplier.start();

        // à mettre dans un thread à cause de l'attente active
        Thread tLogistics = new Thread(new Logistics());
        tLogistics.start();
    }
}
