package Calculator.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton dotButton,eqlButton,clrButton,delButton;
    JPanel panel;
    double a = 0, b = 0, result = 0;
    char operator;
    Font myFonts = new Font("American",Font.BOLD,30);
    Calculator() {
        frame = new JFrame("WelCome to Calculator");
        frame.setSize(400,500);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(40,25,300,50);
        textField.setFont(myFonts);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        dotButton = new JButton(".");
        eqlButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0]= addButton;
        functionButtons[1]= subButton;
        functionButtons[2]= mulButton;
        functionButtons[3]= divButton;
        functionButtons[4]= dotButton;
        functionButtons[5]= eqlButton;
        functionButtons[6]= delButton;
        functionButtons[7]= clrButton;

        for (int i = 0; i <8 ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFonts);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }
        delButton.setBounds(40,410,145,40);
        clrButton.setBounds(195,410,145,40);

        panel = new JPanel();
        panel.setBounds(40,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.gray);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(dotButton);
        panel.add(numberButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dotButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            a= Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton){
            a= Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            a= Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton){
            a= Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == eqlButton){
            b= Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = a + b;
                case '-' -> result = a - b;
                case '*' -> result = a * b;
                case '/' -> result = a / b;
            }
            textField.setText(String.valueOf(result));
            a=result;
        }
        if (e.getSource() == clrButton){
            textField.setText("");
        }
        if (e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }
}
