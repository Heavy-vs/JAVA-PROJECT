package java_project;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dashboard {
     Dashboard(){
            JFrame dashFrame = new JFrame("Your DashBoard");
            dashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dashFrame.setResizable(false);
            dashFrame.setSize(800,800);
            dashFrame.setVisible(true);
            // Now we will create a box like div to add value 
            JPanel Dpanel = new JPanel();
            Dpanel.setLayout( new BoxLayout(Dpanel, BoxLayout.Y_AXIS));
        }
}
