package agent;

import javax.swing.*;

/**
 * Created by patrick-edouard on 4/14/14.
 */
public class DialogueTranspoter extends JDialog{

    private Transporter transporter;
    private JProgressBar progressBar;
    JLabel company;
    JTextArea textCompany;
    JLabel messageOk;

    public DialogueTranspoter(Transporter transporter){
        this.transporter=transporter;
        this.initWindow();
        this.initComponent();
        this.initProgressBar();
        this.setVisible(true);
        this.progress();
    }

    private void progress(){
        for(int i = 0 ; i <= 100; ++i){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.progressBar.setValue(i);
        }
        messageOk = new JLabel("The products are transported");
        this.messageOk.setBounds(100, 400, 100, 50);
        this.add(messageOk);
    }
    
    private void initComponent(){
    	company = new JLabel("Company : ");
        this.company.setBounds(5, 50, 100, 50);
        this.add(company);

        this.textCompany = new JTextArea("Norbert Dentressangle");
        this.textCompany.setBounds(150, 50, 300, 50);
        this.textCompany.setEditable(false);
        this.add(textCompany);
        
        messageOk = new JLabel("The products are transported");
        this.messageOk.setBounds(175, 350, 200, 50);
        this.add(messageOk);
    }

    private void initProgressBar(){
        this.progressBar = new JProgressBar();
        this.progressBar.setBounds(50,200,400,25);
        this.add(progressBar);
    }

    private void initWindow(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Transporter");
        this.setLayout(null);
        this.setBounds(1150,50,500,500);

    }


    public static void main(String[] args){
        new DialogueTranspoter(null);
    }
}
