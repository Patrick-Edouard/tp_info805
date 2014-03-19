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
    JTextArea textRequierement;
    JTextArea textCost;
    JTextArea textTime;
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
        this.setLayout(new GridLayout(2,2));
        // set layout null => tu places les composants à la main avec des setBounds(x,y,w,h); sur chaque composant
        this.setBounds(1150,50,500,500);

    }

    private void initComponent(){
        buttonSend = new JButton("Respond");
        buttonSend.addActionListener(supplier);
        this.add(buttonSend);
    }

    public void requestReceived(Tuple tuple) {
        textRequierement = new JTextArea(tuple.getTemplate().get("requierements"));
        //ajoute un bord au composant
        textRequierement.setBorder(new LineBorder(Color.black));
        this.add(textRequierement);
        textCost = new JTextArea(tuple.getTemplate().get("cost"));
        textCost.setBorder(new LineBorder(Color.black));
        this.add(textCost);
        textTime = new JTextArea(tuple.getTemplate().get("time"));
        textTime.setBorder(new LineBorder(Color.black));
        this.add(textTime);
        textQuantity = new JTextArea(tuple.getTemplate().get("quantity"));
        textQuantity.setBorder(new LineBorder(Color.black));
        this.add(textQuantity);
        this.revalidate();
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
