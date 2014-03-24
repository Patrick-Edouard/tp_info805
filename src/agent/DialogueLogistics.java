package agent;

import tuple.Tuple;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

/**
 * Created by patrick-edouard on 3/18/14.
 */
public class DialogueLogistics extends JDialog{

    private Logistics logistics;
    public JButton buttonSend;
    public JLabel request;
    private JTextArea customerRequest;

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
        this.setLayout(null);
        this.setBounds(600, 50, 500, 500);
    }

    private void initComponent(){
        customerRequest = new JTextArea("No query yet...");
        request = new JLabel("Customer query : ");
        //Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        //this.customerRequest.setBorder(border);
        this.customerRequest.setBounds(120, 50, 300, 300);
        this.request.setBounds(5, 50, 100, 50);
        this.add(customerRequest);
        this.add(request);
        buttonSend = new JButton("Send to Suppliers");
        buttonSend.addActionListener(logistics);
        this.buttonSend.setBounds(180, 400, 150, 25);
        this.add(buttonSend);
    }
}
