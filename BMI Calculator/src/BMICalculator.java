import javax.swing.*;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
 
public class BMICalculator extends JFrame implements ActionListener {
    // Instance variables
    private JTextField weightField;
    private JTextField heightField;
    private JTextField ageField;
    private JLabel resultLabel;
    private JTextArea computationArea;
    private ArrayList<String> previousComputations;
    private static final int MAX_COMPUTATIONS = 5;
    private JComboBox<String> sexDropdown;
 
    // Constructor
    public BMICalculator() {
        setTitle("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
 
        // Create labels and text fields
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setBounds(35, 90, 80, 25);
        weightField = new JTextField();
        weightField.setBounds(120, 90, 200, 30);
 
        JLabel heightLabel = new JLabel("Height (cm):");
        heightLabel.setBounds(35, 130, 80, 25);
        heightField = new JTextField();
        heightField.setBounds(120, 130, 200, 30);
 
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(35, 170, 80, 25);
        ageField = new JTextField();
        ageField.setBounds(120, 170, 200, 30);
 
        // Create the result label
        resultLabel = new JLabel("Your BMI will be calculated here");
        resultLabel.setBounds(10, 210, 400, 25);
 
        // Create the gender dropdown
        String[] sex = {"Male", "Female"};
        sexDropdown = new JComboBox<>(sex);
        sexDropdown.setBounds(35, 30, 200, 30);
 
        // Create the calculate button
        JButton calculateButton = new JButton("CALCULATE");
        calculateButton.setBounds(250, 235, 150, 30);
        calculateButton.addActionListener(this);
 
        // Create the reset button
        JButton resetButton = new JButton("RESET");
        resetButton.setBounds(50, 235, 150, 30);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
 
        // Create the computation area
        computationArea = new JTextArea();
        computationArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(computationArea);
        scrollPane.setBounds(10, 325, 400, 100);
 
        // Add All components inside the frame
        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(ageLabel);
        add(ageField);
        add(sexDropdown);
        add(calculateButton);
        add(resetButton);
        add(scrollPane);
 
        previousComputations = new ArrayList<>();
 
        setSize(450, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMICalculator());
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CALCULATE")) {
            calculateBMI();
            expandFrame();
        }
    }
 
    private void calculateBMI() {
        // Get the input values from the text input field
        double weight = Double.parseDouble(weightField.getText());
        double height = Double.parseDouble(heightField.getText()) / 100.0;
        int age = Integer.parseInt(ageField.getText());
        String gender = (String) sexDropdown.getSelectedItem();
 
        // Calculate the BMI
        double bmi = weight / (height * height);
 
        // Format BMI to two decimal
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedBMI = df.format(bmi);
 
        // BMI category
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal weight";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }
 
        // Display the result
        resultLabel.setText("Your BMI is " + formattedBMI + " (" + category + ")");
 
        // Add computation
        String computation = "Weight: " + weight + " kg " + "\n" + "Height: " + height * 100 + " cm" + "\n" + "Age: " + age + "\n" + "Gender: " + gender + "\n" + "BMI: " + formattedBMI + "\n" + "Status:" + "(" + category + ")";
        previousComputations.add(computation);
 
        // Keep only the last MAX_COMPUTATIONS computations
        if (previousComputations.size() > MAX_COMPUTATIONS) {
            previousComputations.remove(0);
        }
 
        // Update the computation area
        computationArea.setText(String.join("\n\n", previousComputations));
    }
 
    private void resetFields() {
        weightField.setText("");
        heightField.setText("");
        ageField.setText("");
        resultLabel.setText("Your BMI will be calculated here");
    }
 
    private void expandFrame() {
        setSize(450, 500);
    }
}
