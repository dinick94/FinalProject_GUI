package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Configuration extends JFrame {
    private JLabel editDataLabel, removeCharactersLabel, removeWordsLabel, tableNameLabel, responseLabel;
    private JButton removeCharactersDefaultButton, removeWordsDefaultButton, tableNameDefaultButton, backButton, processButton;
    private JTextField removeCharactersTextField, removeWordsTextField, tableNameTextField, responseTextField;
    private JPanel rows[], finishPanel;
    private final int MAX_ROWS = 10;

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    EditData frame = new EditData();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public EditData(){


        setTitle("Import Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50, 600,400);

        ButtonListener listener = new ButtonListener();

        editDataLabel = new JLabel("Edit data");
        removeCharactersLabel = new JLabel("Remove characters");
        removeWordsLabel = new JLabel("Remove words");
        tableNameLabel = new JLabel("Table name");
        responseLabel = new JLabel("Response");

        removeCharactersDefaultButton = new JButton("Default");
        removeWordsDefaultButton = new JButton("Default");
        tableNameDefaultButton = new JButton("Default");
        backButton = new JButton("Back");
        processButton = new JButton("Import");

        removeCharactersTextField = new JTextField(30);
        removeWordsTextField = new JTextField(30);
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
