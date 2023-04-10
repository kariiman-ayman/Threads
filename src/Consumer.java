import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {

    Buffer bfr;
    int count = 0;
    String LargestPrime;
    String file;
    long StartTime;

    public Consumer(Buffer bfr, String file, long StartTime) {
        this.bfr=bfr;
        this.file=file;
        this.StartTime=StartTime;;
    }

    @Override
    public void run() {
        String item;
        
        try {
            FileWriter txtFile = new FileWriter(file);
            while (true) {
                if (bfr.count == 0 && bfr.check == true) {
                    txtFile.close();
                    long endTime = System.currentTimeMillis();
                    JFrame jFrame2 =new JFrame("Output");
                    jFrame2.getContentPane().setBackground( Color.LIGHT_GRAY);
                    //-------------------------------------
                    JLabel l1 = new JLabel("The Largest Prime Number    "+ LargestPrime);
                    l1.setForeground(new Color(204, 0 , 0));
                    l1.setBounds(30, 20, 700,30);
                    //--------------------------------------
                    JLabel l2 = new JLabel("# of elements (Prime Numbers) generated      "+ Integer.toString(count));
                    l2.setForeground(new Color(204, 0 , 0));
                    l2.setBounds(30, 60, 700,30);
                    long timeElapsed = (endTime-StartTime);
                    //--------------------------------------
                    JLabel l3 = new JLabel("Time elapsed since the start of processing      "+String.valueOf(timeElapsed) + " ms");
                    l3.setForeground(new Color(204, 0 , 0));
                    l3.setBounds(30, 90, 700,30);

                    jFrame2.add(l1);
                    jFrame2.add(l2);
                    jFrame2.add(l3);
                    jFrame2.setBounds(100, 100,100 ,100);
                    jFrame2.setSize(500, 250);
                    jFrame2.setLayout(null);
                    jFrame2.setVisible(true);
                    TimeUnit.SECONDS.sleep(20);
                    System.exit(0);
                } else {
                    item = bfr.consume();
                    txtFile.write('"'+ item + '"'+", ");
                    LargestPrime = item;
                    count++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
           Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
