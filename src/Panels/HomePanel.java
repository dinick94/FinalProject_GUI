package Panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;

public class HomePanel extends JPanel {

    private JLabel label;
    private JPanel upperPanel, lowerPanel, finishPanel, leftSpace, rightSpace, centerSpace;
    private JButton viewData, importData, editData, exportData, configuration, readme;

    public HomePanel ()
    {
        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        ButtonListener listener = new ButtonListener();

        label = new JLabel ("File I/O");

        finishPanel = new JPanel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        rightSpace = new JPanel();
        leftSpace = new JPanel();
        centerSpace = new JPanel();

        viewData = new JButton("View Data");
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

        setPreferredSize(new Dimension(400, 600));

        centerSpace.setPreferredSize(new Dimension(200, 30));
        upperPanel.setPreferredSize(new Dimension(200,300));
        lowerPanel.setPreferredSize(new Dimension(200, 200));

        rightSpace.setPreferredSize(new Dimension(100, 600));
        leftSpace.setPreferredSize(new Dimension(100, 600));

        finishPanel.setPreferredSize(new Dimension(200, 530));

        label.setPreferredSize(new Dimension(200, 100));
        label.setFont(new Font("Arial", Font.PLAIN, 24));

        int bttnW = 5, bttnH = 5;

        viewData.setMinimumSize(new Dimension(bttnW, bttnH));
        importData.setMinimumSize(new Dimension(bttnW, bttnH));
        editData.setMinimumSize(new Dimension(bttnW, bttnH));
        exportData.setMinimumSize(new Dimension(bttnW, bttnH));

        configuration.setPreferredSize(new Dimension(bttnW, bttnH));
        readme.setPreferredSize(new Dimension(bttnW, bttnH));

        finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.Y_AXIS));
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));

        upperPanel.add(viewData);
        upperPanel.add(importData);
        upperPanel.add(editData);
        upperPanel.add(exportData);


        lowerPanel.add(configuration);
        lowerPanel.add(readme);

        finishPanel.add(label);
        finishPanel.add(upperPanel);
        finishPanel.add(centerSpace);
        finishPanel.add(lowerPanel);

        add(leftSpace);
        add(finishPanel);
        add(rightSpace);

    }


    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();
            if (source == viewData){

            }

        }
    }
}
