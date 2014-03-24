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
    JLabel requirement;
    JTextArea textRequierement;
    JLabel cost;
    JTextArea textCost;
    JLabel time;
    JTextArea textTime;
    JLabel quantity;
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
        this.setLayout(null);     
        this.setBounds(50,50,500,500);
    }

    private void initComponent(){
        textRequierement = new JTextArea("We need badminton racket large-headed.");
        requirement = new JLabel("Requirements : ");
        this.textRequierement.setBounds(100, 50, 300, 50);
        this.requirement.setBounds(5, 50, 100, 50);
        this.add(textRequierement);
        this.add(requirement);
        
        textCost = new JTextArea("39,90€/unit");
        cost = new JLabel("Cost : ");
        this.textCost.setBounds(100, 105, 300, 50);
        this.cost.setBounds(5, 105, 100, 50);
        this.add(textCost);
        this.add(cost);
        
        textTime = new JTextArea("Before April, 2014");
        time = new JLabel("Time : ");
        this.textTime.setBounds(100, 160, 300, 50);
        this.time.setBounds(5, 160, 100, 50);
        this.add(textTime);
        this.add(time);
        
        textQuantity = new JTextArea("One thousand");
        quantity = new JLabel("Quantity : ");
        this.textQuantity.setBounds(100, 215, 300, 50);
        this.quantity.setBounds(5, 215, 100, 50);
        this.add(textQuantity);
        this.add(quantity);
        
        buttonSend = new JButton("Send to Logistic");
        buttonSend.addActionListener(customer);
        this.buttonSend.setBounds(100, 300, 300, 25);
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
