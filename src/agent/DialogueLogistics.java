package agent;

import tuple.Tuple;

import javax.swing.*;
import java.awt.*;

/**
 * Created by patrick-edouard on 3/18/14.
 */
public class DialogueLogistics extends JDialog{

    private Logistics logistics;
    public JButton buttonSend;
    private JLabel customerRequest;

    public DialogueLogistics(Logistics logistics){
        super();
        this.logistics = logistics;
        this.initWindow();
        this.initComponent();
        this.setVisible(true);
    }

    public void displayCustomerRequest(Tuple t){
        this.customerRequest.setText(t.toString());
        this.revalidate();
    }

    private void initWindow(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Logistic");
        this.setLayout(new GridLayout(2,2));
        this.setBounds(600,50,500,450);
    }

    private void initComponent(){
        buttonSend = new JButton("Send to suppliers");
        buttonSend.addActionListener(logistics);
        this.add(buttonSend);
        customerRequest = new JLabel("requete client : ");
        this.add(customerRequest);
    }
}
