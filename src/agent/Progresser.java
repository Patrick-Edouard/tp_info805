package agent;

import javax.swing.*;

/**
 * Created by patrick-edouard on 4/14/14.
 */
public class Progresser implements Runnable{
    private int timer;
    private MyJDialog parent;
    public Progresser(int timer, MyJDialog parent){
        this.timer=timer;
        this.parent=parent;
    }

    @Override
    public void run() {
        for(int i = 0 ; i <= 100; ++i){
            try {
                Thread.sleep(timer/100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.parent.progressBar.setValue(i);

        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.parent.progressBar.setVisible(false);
        this.parent.revalidate();
    }
}
