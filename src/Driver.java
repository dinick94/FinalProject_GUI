import Panels.HomePanel;

import javax.swing.*;
import java.awt.*;

public class Driver {

    public static void main(String args[]){
        JFrame frame = new JFrame ("Home page");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        HomePanel panel = new HomePanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);

}
}
