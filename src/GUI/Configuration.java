package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Configuration extends JFrame {
    private JLabel configurationLabel, sourceFIleLocationLabel, targetFileLocationLabel, databaseFileLabel, tableNameLabel, removeCharactersLabel, removeWordsLabel;
    private JButton backButton, saveButton;
    private JTextField sourceFileTextField, targetFileTextField, tableNameTextField, databaseFIleLocationTextField, removeCharactersTextField, removeWordsTextField;
    private JPanel rows[], finishPanel;
    private final int MAX_ROWS = 14;

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Configuration frame = new Configuration();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public Configuration(){


        setTitle("Import Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50, 600,400);

        ButtonListener listener = new ButtonListener();

        configurationLabel = new JLabel("Default Configurations");
        removeCharactersLabel = new JLabel("Remove characters");
        removeWordsLabel = new JLabel("Remove words");
        tableNameLabel = new JLabel("Table name");
        sourceFIleLocationLabel = new JLabel("Source file location");
        targetFileLocationLabel = new JLabel("Target file location");
        databaseFileLabel = new JLabel("Database file location");



        backButton = new JButton("Back");
        saveButton = new JButton("Save");


        removeCharactersTextField = new JTextField(30);
        removeWordsTextField = new JTextField(30);
        tableNameTextField = new JTextField(30);
        sourceFileTextField = new JTextField(30);
        targetFileTextField = new JTextField(30);
        databaseFIleLocationTextField = new JTextField(30);

        backButton.addActionListener(listener);
        saveButton.addActionListener(listener);

        JPanel rows[] = new JPanel[MAX_ROWS];
        for (int i = 0; i < MAX_ROWS; i++){
            rows[i] = new JPanel();
            rows[i].setLayout(new FlowLayout());
            rows[i].setPreferredSize(new Dimension(150, 10));
            rows[i].setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        finishPanel = new JPanel();

        finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.PAGE_AXIS));

        editDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        editDataLabel.setAlignmentX(Component.LEFT_ALIGNMENT);


        rows[0].add(editDataLabel);
        rows[1].add(removeCharactersLabel);
        rows[2].add(removeCharactersTextField);
        rows[2].add(removeCharactersDefaultButton);
        rows[3].add(removeWordsLabel);
        rows[4].add(removeWordsTextField);
        rows[4].add(removeWordsDefaultButton);
        rows[5].add(tableNameLabel);
        rows[6].add(tableNameTextField);
        rows[6].add(tableNameDefaultButton);
        rows[7].add(responseLabel);
        rows[8].add(responseTextField);
        rows[9].add(backButton);
        rows[9].add(processButton);

        for (int i = 0; i < MAX_ROWS; i++){
            finishPanel.add(rows[i]);
        }

        add(finishPanel);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();
            if (source == removeCharactersDefaultButton){

            }
            if (source ==  backButton){
                HomePanel panel = new HomePanel();
                panel.setVisible(true);
                dispose();
            }
        }
    }

}
