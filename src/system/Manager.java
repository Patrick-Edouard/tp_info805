package system;

import agent.Customer;
import agent.Logistics;
import agent.Supplier;

/**
 * Created by patrick-edouard on 3/18/14.
 */
public class Manager {

    public static void activateLogisticPart(){
        /*
         * Lance les retailer, transporter ect
         */

        Thread tCustomer = new Thread(new Customer());
        tCustomer.start();

    }

    public static void main(String[] args){
        Thread tCustomer = new Thread(new Customer());
        tCustomer.start();

        // à mettre dans un thread à cause de l'attente active
        // Argument à supplier pour préremplir en fonctions de ses capacitées
        Thread tSupplier1 = new Thread(new Supplier());
        tSupplier1.start();

        // à mettre dans un thread à cause de l'attente active
        // Argument à supplier pour préremplir en fonctions de ses capacitées
        Thread tSupplier2 = new Thread(new Supplier());
        tSupplier2.start();

        // à mettre dans un thread à cause de l'attente active
        // Argument à supplier pour préremplir en fonctions de ses capacitées
        Thread tSupplier3 = new Thread(new Supplier());
        tSupplier3.start();

        // à mettre dans un thread à cause de l'attente active
        Thread tLogistics = new Thread(new Logistics());
        tLogistics.start();
    }
}
