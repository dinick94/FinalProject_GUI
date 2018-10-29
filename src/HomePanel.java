import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;

public class HomePanel extends JPanel {

    private JButton pushButton, popButton, peekButton;
    private JLabel label;
    private JPanel panel;
    private JTextArea outputText;
    private JTextField inputText;

    private Stack<String> stack;

    public HomePanel ()
    {

        stack = new Stack<>();

        ButtonListener listener = new ButtonListener();

        pushButton = new JButton("Push");
        pushButton.addActionListener(listener);
        popButton = new JButton("Pop");
        popButton.addActionListener(listener);
        peekButton = new JButton("Peek");
        peekButton.addActionListener(listener);
        inputText = new JTextField(10);
        outputText = new JTextArea(10, 5);

        label = new JLabel ("none");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(450,70));

        panel.add(inputText);
        panel.add(pushButton);
        panel.add(popButton);
        panel.add(peekButton);
        panel.add(label);
        add(panel);
        add(outputText);

        setBackground (Color.white);
        setPreferredSize (new Dimension(350, 200));
    }


    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();
            if (source == pushButton){
                stack.push(inputText.getText());
                inputText.setText("");
            } else if (source == popButton && !stack.empty()){
                label.setText(stack.pop());
            } else if (source == peekButton && !stack.empty()){
                label.setText(stack.peek());
            }
            outputText.setText(stack.toString());
        }
    }


}
