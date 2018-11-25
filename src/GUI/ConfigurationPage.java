package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigurationPage extends JFrame {
    private Configuration configuration;

    private JLabel configurationLabel, sourceFIleLocationLabel, targetFileLocationLabel, databaseFileLabel, tableNameLabel, removeCharactersLabel;
    private JButton backButton, saveButton;
    private JTextField sourceFileTextField, targetFileTextField, tableNameTextField, databaseFIleLocationTextField, removeCharactersTextField;
    private JPanel rows[], finishPanel;
    private final int MAX_ROWS = 12;

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ConfigurationPage frame = new ConfigurationPage();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public ConfigurationPage(){

        configuration = new Configuration();
        configuration.readFromFile();

        setTitle("Import Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50, 400,475);

        ButtonListener listener = new ButtonListener();

        configurationLabel = new JLabel("Default Configurations");
        configurationLabel.setFont(new Font("Arial", Font.BOLD, 22));
        removeCharactersLabel = new JLabel("Remove characters");
        removeCharactersLabel.setFont(new Font("Arial", Font.BOLD, 12));
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
        removeCharactersTextField.setText(configuration.getRemoveCharacters());
        tableNameTextField = new JTextField(30);
        tableNameTextField.setText(configuration.getTableName());
        sourceFileTextField = new JTextField(30);
        sourceFileTextField.setText(configuration.getSourceFileLocation());
        targetFileTextField = new JTextField(30);
        targetFileTextField.setText(configuration.getTargetFileLocation());
        databaseFIleLocationTextField = new JTextField(30);
        databaseFIleLocationTextField.setText(configuration.getDatabaseFileLocation());

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
        rows[11].add(backButton);
        rows[11].add(saveButton);

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
            if (source == saveButton){
                configuration.setDatabaseFileLocation(databaseFIleLocationTextField.getText());
                configuration.setRemoveCharacters(removeCharactersTextField.getText());
                configuration.setSourceFileLocation(sourceFileTextField.getText());
                configuration.setTableName(tableNameTextField.getText());
                configuration.setTargetFileLocation(targetFileTextField.getText());
                configuration.writeToFile();
            }
            if (source ==  backButton){
                HomePanel frame = new HomePanel();
                frame.setVisible(true);
                dispose();
            }
        }
    }

}
