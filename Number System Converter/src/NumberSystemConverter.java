import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class NumberSystemConverter extends JFrame {
    JLabel toLabel, fromLabel, inputLabel, outputLabel, titleLabel;
    JComboBox<String> to, from;
    JTextField input, output;
    JButton calculateButton, clearButton;
    Font labels, font, title, inputs;

    //constructor
    public NumberSystemConverter() {
        super("Number System Converter");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(615, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initialiseObjects();
    }

    public void initialiseObjects() {
        //fonts
        font = new Font("Arial", Font.PLAIN, 20);
        labels = new Font("Arial", Font.PLAIN, 15);
        title = new Font("Arial", Font.PLAIN, 24);
        inputs = new Font("Arial", Font.PLAIN, 16);

        // setting up dropdown
        to = new JComboBox<>(new String[]{"Binary", "Octal", "Hexadecimal", "Decimal"});
        to.setFont(inputs);
        to.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };
            }
        });
        to.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(to);

        from = new JComboBox<>(new String[]{"Binary", "Octal", "Hexadecimal", "Decimal"});
        from.setFont(inputs);
        from.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };
            }
        });
        from.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(from);
        
        from.setFont(inputs);
        add(from);

        //input field
        input = new JTextField(20);
        input.setFont(inputs);
        input.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(input);

        //output field
        output = new JTextField(20);
        output.setFont(inputs);
        output.setEditable(false);
        output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        output.setBackground(Color.white);
        add(output);

        // setting up convert button
        calculateButton = new JButton("Calculate");
        calculateButton.setFont(inputs);
        calculateButton.setBackground(Color.WHITE);
        calculateButton.setFocusable(false);
        calculateButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(calculateButton);

        // setting up clear button
        clearButton = new JButton("Clear");
        clearButton.setFont(inputs);
        clearButton.setBackground(Color.WHITE);
        clearButton.setFocusable(false);
        clearButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(clearButton);
        
        clearButton.addActionListener(l -> {
            input.setText("");
            output.setText("");
        });

        // setting up labels
        toLabel = new JLabel("Convert to:");
        toLabel.setFont(labels);
        add(toLabel);

        fromLabel = new JLabel("Convert from:");
        fromLabel.setFont(labels);
        add(fromLabel);

        inputLabel = new JLabel("Input:");
        inputLabel.setFont(labels);
        //add(inputLabel);

        outputLabel = new JLabel("");
        outputLabel.setFont(labels);
        add(outputLabel);

        titleLabel = new JLabel("Value to convert");
        titleLabel.setFont(title);
        add(titleLabel);

        // call makeGUI method
        makeGUI();
    }

    public void makeGUI() {
        // setting up layout
        titleLabel.setBounds(200, 15, 300, 30);
        inputLabel.setBounds(140, 83, 100, 25);
        input.setBounds(150, 80, 300, 30);;
        fromLabel.setBounds(150, 130, 120, 30);
        from.setBounds(250, 130, 200, 30);
        toLabel.setBounds(160, 180, 120, 30);
        to.setBounds(250, 180, 200, 30);

        outputLabel.setBounds(80, 285, 100, 25);

        output.setBounds(150, 280,300, 30);
        calculateButton.setBounds(475, 230, 100, 34);
        clearButton.setBounds(25, 230, 100, 34);

        calculateButton.addActionListener(l -> {
            String in = input.getText();
            String out = "";
            String convertTo = String.valueOf(to.getSelectedItem());
            String convertFrom = String.valueOf(from.getSelectedItem());
            try {
                if (convertFrom.equals("Decimal")) {
                    if (convertTo.equals("Binary")) {
                        out = Integer.toBinaryString(Integer.parseInt(in));
                    } else if (convertTo.equals("Hexadecimal")) {
                        out = Integer.toHexString(Integer.parseInt(in)).toUpperCase();
                    } else if (convertTo.equals("Octal")) {
                        out = Integer.toOctalString(Integer.parseInt(in));
                    }
                } else if (convertFrom.equals("Binary")) {
                    if (convertTo.equals("Decimal")) {
                        out = String.valueOf(Integer.parseInt(in, 2));
                    } else if (convertTo.equals("Hexadecimal")) {
                        out = Integer.toHexString(Integer.parseInt(in, 2)).toUpperCase();
                    } else if (convertTo.equals("Octal")) {
                        out = Integer.toOctalString(Integer.parseInt(in, 2));
                    }
                } else if (convertFrom.equals("Hexadecimal")) {
                    if (convertTo.equals("Decimal")) {
                        out = String.valueOf(Integer.parseInt(in, 16));
                    } else if (convertTo.equals("Binary")) {
                        out = Integer.toBinaryString(Integer.parseInt(in, 16));
                    } else if (convertTo.equals("Octal")) {
                        out = Integer.toOctalString(Integer.parseInt(in, 16));
                    }
                } else if (convertFrom.equals("Octal")) {
                    if (convertTo.equals("Decimal")) {
                        out = String.valueOf(Integer.parseInt(in, 8));
                    } else if (convertTo.equals("Binary")) {
                        out = Integer.toBinaryString(Integer.parseInt(in, 8));
                    } else if (convertTo.equals("Hexadecimal")) {
                        out = Integer.toHexString(Integer.parseInt(in, 8)).toUpperCase();
                    }
                }
                output.setText(out);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

        // Main method
        public static void main(String[] args) {
            JFrame frame = new JFrame("Number Converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new NumberSystemConverter());
            frame.pack();
            frame.setVisible(true);
    }
}
