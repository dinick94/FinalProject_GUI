package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditData extends JFrame {
    private Configuration configuration;

    private JLabel editDataLabel, removeCharactersLabel, tableNameLabel, responseLabel;
    private JButton removeCharactersDefaultButton, tableNameDefaultButton, backButton, processButton;
    private JTextField removeCharactersTextField, tableNameTextField, responseTextField;
    private JPanel rows[], finishPanel;
    private final int MAX_ROWS = 8;

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

        configuration = new Configuration();
        configuration.readFromFile();

        setTitle("Import Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50, 600,400);

        ButtonListener listener = new ButtonListener();

        editDataLabel = new JLabel("Edit data");
        removeCharactersLabel = new JLabel("Remove characters");
        tableNameLabel = new JLabel("Table name");
        responseLabel = new JLabel("Response");

        removeCharactersDefaultButton = new JButton("Default");
        tableNameDefaultButton = new JButton("Default");
        backButton = new JButton("Back");
        processButton = new JButton("Process");

        removeCharactersTextField = new JTextField(30);
        tableNameTextField = new JTextField(30);
        responseTextField = new JTextField(25);

        removeCharactersDefaultButton.addActionListener(listener);
        tableNameDefaultButton.addActionListener(listener);
        backButton.addActionListener(listener);
        processButton.addActionListener(listener);

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
        rows[3].add(tableNameLabel);
        rows[4].add(tableNameTextField);
        rows[4].add(tableNameDefaultButton);
        rows[5].add(responseLabel);
        rows[6].add(responseTextField);
        rows[7].add(backButton);
        rows[7].add(processButton);

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
            if (source == processButton){
                /*
                    PROCESS
                 */
            }
            if (source == removeCharactersDefaultButton){
                removeCharactersTextField.setText(configuration.getRemoveCharacters());
            }
            if (source == tableNameDefaultButton){
                tableNameTextField.setText(configuration.getTableName());
            }
            if (source ==  backButton){
                HomePanel frame = new HomePanel();
                frame.setVisible(true);
                dispose();
            }
        }
    }
}
