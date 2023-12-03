package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    private JLabel heading;
    private Timer timer;
    private String titleText = "EMPLOYEE MANAGEMENT SYSTEM";
    private int currentIndex = 0;

    public Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel();
        add(heading);
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("Courier New", Font.PLAIN, 60));

        // Set up timer for animation
        int delay = 100; // Milliseconds between each letter
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < titleText.length()) {
                    heading.setText(titleText.substring(0, currentIndex + 1));
                    currentIndex++;
                } else {
                    // Stop the timer when the title is fully displayed
                    timer.stop();
                }
            }
        });

        // Start the timer
        timer.start();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);

        JButton nextButton = new JButton("NEXT");
        nextButton.setFont(new Font("Courier",Font.PLAIN,20));
        nextButton.setBounds(400,400,300,70);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        image.add(nextButton);

        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Splash();
    }
}


