package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewData extends JFrame {

    JLabel label;
    JTable table;
    JButton back, load;
    JPanel buttonPanel, finishPanel;

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ViewData frame = new ViewData();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewData(){

        setTitle("View Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(50,50,500,200);


        ButtonListener listener = new ButtonListener();

        buttonPanel = new JPanel();
        finishPanel = new JPanel();
        label = new JLabel("View Data");
        table = new JTable(6,6);
        back = new JButton("Back");
        load = new JButton("Load");

        label.setFont(new Font("Arial", Font.BOLD, 18));

        back.addActionListener(listener);
        load.addActionListener(listener);

        finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.PAGE_AXIS));

        label.setAlignmentX(LEFT_ALIGNMENT);
        back.setAlignmentX(RIGHT_ALIGNMENT);
        load.setAlignmentX(LEFT_ALIGNMENT);



        buttonPanel.add(back);
        buttonPanel.add(load);

        finishPanel.add(label);
        finishPanel.add(table);
        finishPanel.add(buttonPanel);

        add(finishPanel);
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
            if (source ==  back){
                HomePanel panel = new HomePanel();
                panel.setVisible(true);
                dispose();
            }
        }
    }

}
