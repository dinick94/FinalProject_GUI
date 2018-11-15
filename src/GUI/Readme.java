package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
        programSummary = new JLabel("Program Summary: This program that will allows a user to: \n" +
                " a)Import data from a flat fileinto a database. \n" +
                " b) Edit data in a database table by removing characters or words.\n" +
                " c) View data that is in a database table.\n" +
                " d) Export data from a database to a flat file.\n" +
                " e) Configure and leverage presets via a configuration screen.");
        authors = new JLabel("Authors: Ridwanullah Ibraheem, Dzmitry Nikitsionak, Brett Economas, Eric Hartman");
        requirements = new JLabel("Requirements: The SQLite JDBC Driver Jar file provided with the project must be added to the project via your IDE.");

        finishPanel = new JPanel();

        backButton = new JButton("Back");

        backButton.addActionListener(listener);

        readmeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        programSummary.setFont(new Font("Arial", Font.PLAIN, 14));

        finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.PAGE_AXIS));

        backButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        finishPanel.add(readmeLabel);
        finishPanel.add(programSummary);
        finishPanel.add(authors);
        finishPanel.add(requirements);

        add(backButton);
        add(finishPanel);


    }


    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();
            JFrame newWIndow;
            if (source == backButton){
                newWIndow = new Configuration();
            } else return;
            newWIndow.setVisible(true);
            dispose();
        }

    }
}

