package agent;

import agent.Customer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by patrick-edouard on 3/18/14.
 */
public class DialogueCustomer extends JDialog{

    private Customer customer;
    JButton buttonSend;
    JTextArea textRequierement;
    JTextArea textCost;
    JTextArea textTime;
    JTextArea textQuantity;

    public DialogueCustomer(Customer customer){
        super();
        this.customer = customer;
        this.initWindow();
        this.initComponent();
        this.setVisible(true);
    }

    private void initWindow(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Customer");
        this.setLayout(new GridLayout(2,2));
        this.setBounds(50,50,500,500);

    }

    private void initComponent(){
        textRequierement = new JTextArea("Besoin de tant de truc nanana");
        this.add(textRequierement);
        textCost = new JTextArea("Cout : 40e/u");
        this.add(textCost);
        textTime = new JTextArea("Avant le 25 mars");
        this.add(textTime);
        textQuantity = new JTextArea("Un bon gros paquet");
        this.add(textQuantity);
        buttonSend = new JButton("Send to logistic");
        buttonSend.addActionListener(customer);
        this.add(buttonSend);
    }

    public String getRequierement(){
        return textRequierement.getText();
    }

    public String getcost(){
        return textCost.getText();
    }

    public String getTime(){
        return textTime.getText();
    }

    public String getQuantity(){
        return textQuantity.getText();
    }

}
