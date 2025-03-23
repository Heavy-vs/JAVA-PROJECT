package java_project;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class todo_list {
    public static void main(String[] args) {
        DatabaseManager.setupDatabase(); // 🔥 Ensures database is set up before login
        
    JFrame farme = new JFrame("TO-DO List ");
    farme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    farme.setResizable(false);
    farme.setSize(800,800);
    farme.setVisible(true);
    // Now we will create a box like div to add value 
    JPanel panel = new JPanel();
    panel.setLayout( new BoxLayout(panel, BoxLayout.Y_AXIS));
    // panel.setBackground(Color.LIGHT_GRAY);
    
    panel.add(Box.createVerticalStrut(250));

    JLabel tlogin = new JLabel("welcome back! Let's track your progress");
    tlogin.setFont(new Font("Poppin", Font.PLAIN, 18));
    tlogin.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(tlogin);
    
    panel.add(Box.createVerticalStrut(20));

    JButton login = new JButton("Log in");
    login.setFont(new Font("Poppin", Font.BOLD, 18));
    login.setPreferredSize(new Dimension(200,50));
    login.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(login);
    login.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
        farme.dispose();
         new LoginPage(farme);   

        }
    });
    
   

    panel.add(Box.createVerticalStrut(50));
    
    JLabel tsignup = new JLabel("Hey There! Wanna track your progress");
    tsignup.setFont(new Font("Poppin", Font.PLAIN, 18));
    tsignup.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(tsignup);
    
    panel.add(Box.createVerticalStrut(20));

    JButton signup = new JButton("Sign up");
    signup.setFont(new Font("Poppin", Font.BOLD, 18));
    signup.setPreferredSize(new Dimension(200,50));
    signup.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(signup);
    

    farme.add(panel);
    }
}
   