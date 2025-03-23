package java_project;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginPage{
    LoginPage(JFrame mainFrame){
        JFrame frame = new JFrame("LOG-IN");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
frame.setSize(800,800);
frame.setVisible(true);
// Now we will create a box like div to add value 
JPanel lpanel = new JPanel();
lpanel.setLayout( (LayoutManager) new BoxLayout(lpanel, BoxLayout.Y_AXIS));

        lpanel.add(Box.createVerticalStrut(300));

    JLabel log = new JLabel("User Id/User Name");
    log.setFont(new Font("Poppin", Font.PLAIN,18));
    log.setAlignmentX(Component.CENTER_ALIGNMENT);
    lpanel.add(log);

    JTextField user = new JTextField();
    user.setMaximumSize(new Dimension(280,18));
    user.setAlignmentX(Component.CENTER_ALIGNMENT);             
    lpanel.add(user);

        lpanel.add(Box.createVerticalStrut(20));

    JLabel pass = new JLabel("Enter Your Passward");
    pass.setFont( new Font("Poppin",Font.PLAIN, 18));
    pass.setAlignmentX(Component.CENTER_ALIGNMENT);
        lpanel.add(pass);
        
    JPasswordField pas = new JPasswordField();
    pas.setMaximumSize(new Dimension(280,18));
    pas.setAlignmentX(Component.CENTER_ALIGNMENT);
    lpanel.add(pas);

    lpanel.add(Box.createVerticalStrut(20));

    JButton loginbuButton = new JButton("Log in");
    loginbuButton.setFont(new Font("Poppin", Font.BOLD,18));
    loginbuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    lpanel.add(loginbuButton);

    
    lpanel.add(Box.createVerticalStrut(20));
    
    JButton back = new JButton("Back");
    back.setFont(new Font("Poppin", Font.BOLD,18));
    back.setAlignmentX(Component.CENTER_ALIGNMENT);
    lpanel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                mainFrame.setVisible(true);
            }
        });
        
   loginbuButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e){
        String username = user.getText();
        String password = new String(pas.getPassword());
            if (DatabaseManager.validateLogin(username, password)) {
                JOptionPane.showMessageDialog(frame, "Login Successful");
                frame.dispose();
                new Dashboard();
            } 
            else{
                JOptionPane.showMessageDialog(frame, "Invalid  username or password ", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }
   });


    frame.add(lpanel);
    }
   
}   