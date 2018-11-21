package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Readme extends JFrame {

    private JLabel readmeLabel, programSummary, authors, requirements;
    private JPanel finishPanel;
    private JButton backButton;

    public static void main(String args[]){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Readme frame = new Readme();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

    }


    public Readme()
    {
        setTitle("Readme");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50, 500, 320);

        ButtonListener listener = new ButtonListener();

        readmeLabel = new JLabel ("Readme");
        programSummary = new JLabel("<html><b>Program Summary:</b> This program that will allows a user to: <br>" +
                " <b>a)</b> Import data from a flat fileinto a database. <br>" +
                " <b>b)</b> Edit data in a database table by removing characters or words.<br>" +
                " <b>c)</b> View data that is in a database table.<br>" +
                " <b>d)</b> Export data from a database to a flat file.<br>" +
                " <b>e)</b> Configure and leverage presets via a configuration screen.</html>");
        authors = new JLabel("<html><b>Authors:</b> Ridwanullah Ibraheem, Dzmitry Nikitsionak, Brett Economas, Eric Hartman</html>");
        requirements = new JLabel("<html><b>Requirements:</b> The SQLite JDBC Driver Jar file<br>" +
                " provided with the project must be added to the project via your IDE.</html>");

        finishPanel = new JPanel();

        backButton = new JButton("Back");

        backButton.addActionListener(listener);

        readmeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        programSummary.setFont(new Font("Arial", Font.PLAIN, 15));
        authors.setFont(new Font("Arial", Font.PLAIN, 15));
        requirements.setFont(new Font("Arial", Font.PLAIN, 15));

        finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.PAGE_AXIS));

        readmeLabel.setBorder(new EmptyBorder(5,30,10,0));
        programSummary.setBorder(new EmptyBorder(5,5,10,0));
        authors.setBorder(new EmptyBorder(5,5,10,0));
        requirements.setBorder(new EmptyBorder(5,5,10,0));


        finishPanel.add(readmeLabel);
        finishPanel.add(programSummary);
        finishPanel.add(authors);
        finishPanel.add(requirements);
        finishPanel.add(backButton);

        add(finishPanel);



    }


    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();
            JFrame newWIndow;
            if (source == backButton){
                newWIndow = new HomePanel();
            } else return;
            newWIndow.setVisible(true);
            dispose();
        }

    }
}

