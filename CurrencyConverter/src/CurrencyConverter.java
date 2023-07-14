import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrencyConverter extends JFrame {
    private static final double[] RATES = {0.018, 0.83, 110.36, 1.33, 1.0, 1.40, 23.93, 0.59, 0.12, 0.000088};
    private static final String[] CURRENCIES = {"USD", "EUR", "JPY", "CAD", "PHP", "AUD", "KRW", "NZD", "CNY", "BTC"};
    
    private JTextField inputField;
    private JComboBox<String> currencyFromBox, currencyToBox;
    private JLabel resultLabel;
    
    public CurrencyConverter() {
        super("Currency Converter");
        setSize( 420, 420 );
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        Font font = new Font("Serif", Font.PLAIN, 20 );
        
        JLabel inputLabel = new JLabel("Amount:");
        inputLabel.setBounds( 160, 0, 100, 50 );
        inputLabel.setFont(font);

        inputField = new JTextField();
        inputField.setBounds( 75, 40, 250, 50 );
        inputField.setFont(font);
        add(inputLabel);
        add(inputField);
        
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds( 50, 120, 100, 50 );
        fromLabel.setFont(font);

        currencyFromBox = new JComboBox<String>(CURRENCIES);
        currencyFromBox.setBounds( 120, 120, 200, 50 );
        add(fromLabel);
        add(currencyFromBox);
        
        JLabel toLabel = new JLabel("To:");
        toLabel.setFont(font);
        toLabel.setBounds( 50, 180, 100, 50 );
        currencyToBox = new JComboBox<String>(CURRENCIES);
        currencyToBox.setBounds( 120, 180, 200, 50 );
        add(toLabel);
        add(currencyToBox);
        
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds( 140, 250, 150, 50 );
        convertButton.setFont(font);
        convertButton.setFocusable(false);
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });
        add(convertButton);
        
        Font font2 = new Font("Arial", Font.PLAIN, 18);
        resultLabel = new JLabel("");
        resultLabel.setBounds( 10, 320, 385, 50 );
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setFont(font2);
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2 ));
        add(resultLabel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
    }
    
    private void convert() {
        try {
            double amount = Double.parseDouble(inputField.getText());
            int fromIndex = currencyFromBox.getSelectedIndex();
            int toIndex = currencyToBox.getSelectedIndex();
            double rate = RATES[toIndex] / RATES[fromIndex];
            double result = amount * rate;
            resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, CURRENCIES[fromIndex], result, CURRENCIES[toIndex]));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input.");
        }
    }
    
    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
