package agent;

import javax.swing.*;

/**
 * Created by patrick-edouard on 4/14/14.
 */
public class DialogueTranspoter extends JDialog{

    private Transporter transporter;
    private JProgressBar progressBar;

    public DialogueTranspoter(Transporter transporter){
        this.transporter=transporter;
        this.initWindow();
        this.initProgressBar();
        this.setVisible(true);
        this.progress();
    }

    private void progress(){
        for(int i = 0 ; i <= 100; ++i){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.progressBar.setValue(i);
        }
    }

    private void initProgressBar(){
        this.progressBar = new JProgressBar();
        this.progressBar.setBounds(50,50,400,25);
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
