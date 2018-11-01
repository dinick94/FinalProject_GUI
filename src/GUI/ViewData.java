package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewData extends JFrame {

    JLabel label;
    JTable table;
    JButton back, load;
    JPanel buttonPanel;

    public ViewData(){

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        ButtonListener listener = new ButtonListener();

        buttonPanel = new JPanel();
        label = new JLabel("View Data");
        table = new JTable(6,6);
        back = new JButton("Back");
        load = new JButton("Load");

        label.setFont(new Font("Arial", Font.BOLD, 18));

        label.setAlignmentX(RIGHT_ALIGNMENT);
        back.setAlignmentX(RIGHT_ALIGNMENT);
        load.setAlignmentX(LEFT_ALIGNMENT);

        buttonPanel.add(back);
        buttonPanel.add(load);

        add(label);
        add(table);
        add(buttonPanel);

    }








    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();
            if (source == load){
                /*

                       Action when "LOAD" button pushed

                 */
            }



        }
    }

}
