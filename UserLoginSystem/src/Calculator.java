import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton decimalButton;
    private JButton clearButton;
    private JButton onOffButton;

    private double firstNumber;
    private String operator;

    private boolean isOn;

    public Calculator() {
        setTitle("Calculator");
        setSize(500, 435);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setBounds(0, 0, 550, 80);
        add(displayField);

        onOffButton = new JButton("On/Off");
        onOffButton.setBounds( 10, 80, 115, 60 );
        onOffButton.addActionListener(this);
        add(onOffButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3));
        buttonPanel.setBounds(10, 150, 350, 240);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }

        operatorButtons = new JButton[5];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        operatorButtons[4] = new JButton("%");

        operatorButtons[3].setBounds( 370, 80, 110, 60 );
        operatorButtons[2].setBounds( 370, 150, 110, 60 );
        operatorButtons[1].setBounds( 370, 210, 110, 60 );
        operatorButtons[0].setBounds( 370, 270, 110, 60 );
        operatorButtons[4].setBounds( 120, 330, 80, 60 );
        
        add(operatorButtons[3]);
        add(operatorButtons[2]);
        add(operatorButtons[1]);
        add(operatorButtons[0]);
        add(operatorButtons[4]);

        for (int i = 0; i < 5; i++) {
            operatorButtons[i].addActionListener(this);
        }

        equalsButton = new JButton("=");
        equalsButton.setBounds(370, 330, 110, 60 );
        equalsButton.addActionListener(this);
        add(equalsButton);

        decimalButton = new JButton(".");
        decimalButton.addActionListener(this);
        decimalButton.setBounds(200, 330, 80, 60 );
        add(decimalButton);

        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        clearButton.setBounds(280, 330, 80, 60 );
        add(clearButton);

        add(buttonPanel);

        setVisible(true);

        isOn = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isOn) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (buttonText.equals("On/Off")) {
                isOn = !isOn;
                displayField.setText("");
            } else if (buttonText.equals("C")) {
                displayField.setText("");
            } else if (buttonText.equals("=")) {
                double secondNumber = Double.parseDouble(displayField.getText());
                double result = calculate(firstNumber, secondNumber, operator);
                displayField.setText(String.valueOf(result));
            } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") ||
                    buttonText.equals("/") || buttonText.equals("%")) {
                firstNumber = Double.parseDouble(displayField.getText());
                operator = buttonText;
                displayField.setText("");
            } else {
                String currentText = displayField.getText();
                displayField.setText(currentText + buttonText);
            }
        }
    }

    private double calculate(double num1, double num2, String operator) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}