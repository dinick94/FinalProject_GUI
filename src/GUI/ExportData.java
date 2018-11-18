package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportData extends JFrame {

    private JLabel targetDataLabel, targetFileLocationLabel, dataBaseLocationLabel, tableNameLabel, responseLabel;
    private JButton targetFileDefaultButton, dbLocationDefaultButton, tableNameDefaultButton, backButton, exportButton;
    private JTextField targetTextField, dbLocationTextField, tableNameTextField, responseTextField;
    private JPanel rows[], finishPanel;
    private final int MAX_ROWS = 10;

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ImportData frame = new ImportData();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public ExportData(){


        setTitle("Import Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(50,50, 600,400);

        ButtonListener listener = new ButtonListener();

        targetDataLabel = new JLabel("Export data");
        targetFileLocationLabel = new JLabel("Target");
        dataBaseLocationLabel = new JLabel("Database location");
        tableNameLabel = new JLabel("Table name");
        responseLabel = new JLabel("Response");

        targetFileDefaultButton = new JButton("Default");
        dbLocationDefaultButton = new JButton("Default");
        tableNameDefaultButton = new JButton("Default");
        backButton = new JButton("Back");
        exportButton = new JButton("Export");

        targetTextField = new JTextField(30);
        dbLocationTextField = new JTextField(30);
        tableNameTextField = new JTextField(30);
        responseTextField = new JTextField(25);

        backButton.addActionListener(listener);

        JPanel rows[] = new JPanel[MAX_ROWS];
        for (int i = 0; i < MAX_ROWS; i++){
            rows[i] = new JPanel();
            rows[i].setLayout(new FlowLayout());
            rows[i].setPreferredSize(new Dimension(150, 10));
            rows[i].setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        finishPanel = new JPanel();

        finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.PAGE_AXIS));

        targetDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        targetDataLabel.setAlignmentX(Component.LEFT_ALIGNMENT);


        rows[0].add(targetDataLabel);
        rows[1].add(targetFileLocationLabel);
        rows[2].add(targetTextField);
        rows[2].add(targetFileDefaultButton);
        rows[3].add(dataBaseLocationLabel);
        rows[4].add(dbLocationTextField);
        rows[4].add(dbLocationDefaultButton);
        rows[5].add(tableNameLabel);
        rows[6].add(tableNameTextField);
        rows[6].add(tableNameDefaultButton);
        rows[7].add(responseLabel);
        rows[8].add(responseTextField);
        rows[9].add(backButton);
        rows[9].add(exportButton);

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
            if (source == targetFileDefaultButton){

            }
            if (source ==  backButton){
                HomePanel frame = new HomePanel();
                frame.setVisible(true);
                dispose();
            }
        }
    }
}
