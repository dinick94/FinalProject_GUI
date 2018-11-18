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
        setBounds(50,50, 400,470);

        ButtonListener listener = new ButtonListener();

        configurationLabel = new JLabel("Default Configurations");
        configurationLabel.setFont(new Font("Arial", Font.BOLD, 22));
        removeCharactersLabel = new JLabel("Remove characters");
        removeCharactersLabel.setFont(new Font("Arial", Font.BOLD, 12));
        removeWordsLabel = new JLabel("Remove words");
        removeWordsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        tableNameLabel = new JLabel("Table name");
        tableNameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        sourceFIleLocationLabel = new JLabel("Source file location");
        sourceFIleLocationLabel.setFont(new Font("Arial", Font.BOLD, 12));
        targetFileLocationLabel = new JLabel("Target file location");
        targetFileLocationLabel.setFont(new Font("Arial", Font.BOLD, 12));
        databaseFileLabel = new JLabel("Database file location");
        databaseFileLabel.setFont(new Font("Arial", Font.BOLD, 12));



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

        rows[0].add(configurationLabel);
        rows[1].add(sourceFIleLocationLabel);
        rows[2].add(sourceFileTextField);
        rows[3].add(targetFileLocationLabel);
        rows[4].add(targetFileTextField);
        rows[5].add(databaseFileLabel);
        rows[6].add(databaseFIleLocationTextField);
        rows[7].add(tableNameLabel);
        rows[8].add(tableNameTextField);
        rows[9].add(removeCharactersLabel);
        rows[10].add(removeCharactersTextField);
        rows[11].add(removeWordsLabel);
        rows[12].add(removeWordsTextField);
        rows[13].add(backButton);
        rows[13].add(saveButton);

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
            if (true){

            }
            if (source ==  backButton){
                HomePanel frame = new HomePanel();
                frame.setVisible(true);
                dispose();
            }
        }
    }

}
