package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ViewData extends JFrame {

    JLabel label;
    JTable table;
    JButton back, load;
    JPanel buttonPanel, finishPanel;

    final int TABLE_MAX_ROWS = 6;
    final int TABLE_MAX_COLUMNS = 6;

    ArrayList<String> testArray = new ArrayList<>();

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ViewData frame = new ViewData();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewData(){


        for (Integer i = 0; i < 36; i++){
            testArray.add("TEST" + i.toString());
        }

        setTitle("View Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(50,50,500,200);


        ButtonListener listener = new ButtonListener();

        buttonPanel = new JPanel();
        finishPanel = new JPanel();
        label = new JLabel("View Data");
        table = new JTable(TABLE_MAX_ROWS,TABLE_MAX_COLUMNS);
        back = new JButton("Back");
        load = new JButton("Load");

        label.setFont(new Font("Arial", Font.BOLD, 18));

        back.addActionListener(listener);
        load.addActionListener(listener);

        finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.PAGE_AXIS));


        buttonPanel.add(back);
        buttonPanel.add(load);

        finishPanel.add(label);
        finishPanel.add(table);
        finishPanel.add(buttonPanel);

        add(finishPanel);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();
            if (source == load){
                /*

                       Action when "LOAD" button pushed

                 */
                loadData(testArray);
            }
            if (source ==  back){
                HomePanel panel = new HomePanel();
                panel.setVisible(true);
                dispose();
            }
        }
    }

    public void loadData(ArrayList<String> dataToLoad){
        for(int i = 0; i < TABLE_MAX_ROWS; i++){
            for(int j = 0; j < TABLE_MAX_COLUMNS; j++){
                table.setValueAt(dataToLoad.get(i * TABLE_MAX_ROWS + j),i,j);
            }
        }
    }

}
