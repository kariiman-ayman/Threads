import javax.swing.*; 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


public class Main {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Calculate The Largest Prime Number");
        jFrame.getContentPane().setBackground( Color.LIGHT_GRAY);

        JLabel label1 = new JLabel("Enter Number ");
        label1.setBounds(30, 20, 120, 30);
        //label1.setFont(new Font("Underlined", Font.PLAIN, 16));
        final JTextField txtF1 = new JTextField();
        txtF1.setBounds(150, 20, 200, 25);
        jFrame.add(label1);
        jFrame.add(txtF1);
        //-------------------------------------------
        JLabel label2 = new JLabel("Enter Buffer Size ");
        label2.setBounds(30, 48, 120, 30);
        final JTextField txtF2 = new JTextField();
        txtF2.setBounds(150, 50, 200, 25);
        jFrame.add(label2);
        jFrame.add(txtF2);
        //-------------------------------------------------
        JLabel label3 = new JLabel("Enter File Name ");
        label3.setBounds(30, 75, 130, 30);
        final JTextField txtF3 = new JTextField();
        txtF3.setBounds(150, 80, 200, 25);
        jFrame.add(label3);
        jFrame.add(txtF3);
        //---------------------------------------------------
        JButton button = new JButton("Start Producer");
        button.setBounds(230, 120, 120, 25);
        jFrame.add(button);

        button.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){

                long StartTime = System.currentTimeMillis();
                int number = Integer.valueOf(txtF1.getText());
                if(number == 0 || number < 0)
                {
                    JFrame jFrame3 = new JFrame("Error");
                    JLabel label = new JLabel(" No prime Numbers ");
                    label.setForeground(new Color(204, 0 , 0));
                    jFrame3.getContentPane().setBackground( Color.LIGHT_GRAY);
                    label.setFont(new Font("Arial", Font.PLAIN, 16));
                    label.setBounds(100, 50, 500, 50);
                    jFrame3.add(label);
                    jFrame3.setBounds(100, 100,100 ,100);
                    jFrame3.setSize(500, 250);
                    jFrame3.setLayout(null);
                    jFrame3.setVisible(true);

                } else {
                    Buffer bfrSize = new Buffer(Integer.parseInt(txtF2.getText()));
                    String filename = String.valueOf(txtF3.getText());

                    Producer ProducerThread = new Producer(number, bfrSize);
                    Consumer ConsumerThread = new Consumer(bfrSize, filename, StartTime);
                    ProducerThread.start();
                    ConsumerThread.start();
                }

            }
        });
        jFrame.setBounds(100, 100,100 ,100);
        jFrame.setSize(500, 250);
        jFrame.setLayout(null);
        jFrame.setVisible(true); 
    }
}