package agent;

import tuple.Tuple;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by patrick-edouard on 3/18/14.
 */
public class DialogueLogistics extends JDialog{

    private Logistics logistics;
    public JButton buttonSend;
    public JButton buttonSendResponse;
    public JLabel request;
    private JTextArea customerRequest;
    private JList<String> listReponse;

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
        this.customerRequest.setBounds(120, 50, 300, 150);
        this.customerRequest.setBackground(Color.WHITE);
        this.customerRequest.setEditable(false);
        this.request.setBounds(5, 50, 100, 50);
        this.add(customerRequest);
        this.add(request);
        buttonSend = new JButton("Send to Suppliers");
        buttonSend.addActionListener(logistics);
        this.buttonSend.setBounds(180, 400, 150, 25);
        this.add(buttonSend);
    }

    void displayResponse(ArrayList<Tuple> reponse){

        String[] responseArray = new String[reponse.size()];

        for(int i = 0; i < reponse.size(); ++i){
            responseArray[i]= reponse.get(i).toString();
        }

        listReponse = new JList<String>(responseArray);

        listReponse.setBounds(50,200,550,550);

        JScrollPane scrollPane = new JScrollPane(listReponse);
        scrollPane.setBounds(100,250,300,100);

        this.add(scrollPane);

        buttonSendResponse = new JButton("Send CDC to customer");

        buttonSendResponse.setBounds(180,400,150,25);

        buttonSendResponse.addActionListener(logistics);

        this.add(buttonSendResponse);

        buttonSend.setBounds(0,0,0,0);
        buttonSend.setVisible(false);

        this.revalidate();
    }
}
