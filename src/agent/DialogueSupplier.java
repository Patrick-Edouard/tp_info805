package agent;

import tuple.Tuple;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

/**
 * Created by patrick-edouard on 3/19/14.
 */
public class DialogueSupplier extends JDialog{


    private Supplier supplier;
    JButton buttonSend;
    JLabel requirement;
    JTextArea textRequierement;
    JLabel cost;
    JTextArea textCost;
    JLabel time;
    JTextArea textTime;
    JLabel quantity;
    JTextArea textQuantity;
    public DialogueSupplier(Supplier supplier){
        super();
        this.supplier = supplier;
        this.initWindow();
        this.initComponent();
        this.setVisible(true);
    }

    private void initWindow(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Supplier");
        this.setLayout(null);
        this.setBounds(1150,50,500,500);

    }

    private void initComponent(){
        requirement = new JLabel("Requirements : ");
        this.requirement.setBounds(5, 50, 100, 50);
        this.add(requirement);

        this.textRequierement = new JTextArea();
        this.textRequierement.setBounds(100, 50, 300, 50);
        this.add(textRequierement);
        
 
        cost = new JLabel("Cost : ");
        this.cost.setBounds(5, 105, 100, 50);
        this.add(cost);

        textCost = new JTextArea();
        this.textCost.setBounds(100, 105, 300, 50);
        this.add(textCost);

        time = new JLabel("Time : ");
        this.time.setBounds(5, 160, 100, 50);
        this.add(time);

        textTime = new JTextArea();
        this.textTime.setBounds(100, 160, 300, 50);
        this.add(textTime);

        quantity = new JLabel("Quantity : ");
        this.quantity.setBounds(5, 215, 100, 50);
        this.add(quantity);

        textQuantity = new JTextArea("");
        this.textQuantity.setBounds(100, 215, 300, 50);
        this.add(textQuantity);
    	
        buttonSend = new JButton("Send offer");
        this.buttonSend.setBounds(100,300,300,25);
        buttonSend.addActionListener(supplier);
        this.add(buttonSend);
        
        //this.revalidate();
    }

    public void requestReceived(Tuple tuple) {
    	
        textRequierement.setText(tuple.getTemplate().get("requierements"));

        textCost.setText(tuple.getTemplate().get("cost"));

        textTime.setText(tuple.getTemplate().get("time"));

        textQuantity.setText(tuple.getTemplate().get("quantity"));

        //this.revalidate();
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
