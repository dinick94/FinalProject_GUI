package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePanel extends JFrame {

    private JLabel label;
    private JPanel upperPanel, lowerPanel, finishPanel;
    private JButton viewData, importData, editData, exportData, configuration, readme;

    public static void main(String args[]){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    HomePanel frame = new HomePanel();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

    }


    public HomePanel ()
    {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(50,50, 320, 320);

        ButtonListener listener = new ButtonListener();

        label = new JLabel ("File I/O");

        finishPanel = new JPanel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();

        viewData = new JButton(" View Data  ");
        importData = new JButton("Import Data");
        editData = new JButton("Edit Data");
        exportData = new JButton("Export Data");
        configuration = new JButton("Configuration");
        readme = new JButton("Readme");

        viewData.addActionListener(listener);
        importData.addActionListener(listener);
        editData.addActionListener(listener);
        exportData.addActionListener(listener);
        configuration.addActionListener(listener);
        readme.addActionListener(listener);

        upperPanel.setPreferredSize(new Dimension(320,150));
        lowerPanel.setPreferredSize(new Dimension(320, 100));

        finishPanel.setPreferredSize(new Dimension(320, 250));

        label.setFont(new Font("Arial", Font.PLAIN, 18));

        finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.PAGE_AXIS));
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.PAGE_AXIS));
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.PAGE_AXIS));

        viewData.setAlignmentX(Component.CENTER_ALIGNMENT);
        importData.setAlignmentX(Component.CENTER_ALIGNMENT);
        editData.setAlignmentX(Component.CENTER_ALIGNMENT);
        exportData.setAlignmentX(Component.CENTER_ALIGNMENT);
        configuration.setAlignmentX(Component.CENTER_ALIGNMENT);
        readme.setAlignmentX(Component.CENTER_ALIGNMENT);

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(5,20,20,20));

        upperPanel.add(viewData);
        upperPanel.add(importData);
        upperPanel.add(editData);
        upperPanel.add(exportData);

        lowerPanel.add(configuration);
        lowerPanel.add(readme);
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        finishPanel.add(label);
        finishPanel.add(upperPanel);
        finishPanel.add(lowerPanel);

        add(finishPanel);

    }


    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();
            if (source == viewData){
                ViewData viewData = new ViewData();
                viewData.setVisible(true);
                dispose();
            }
            if (source == importData){
                ImportData importData = new ImportData();
                importData.setVisible(true);
                dispose();
            }

        }
    }
}
