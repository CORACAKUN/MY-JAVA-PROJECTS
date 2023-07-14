import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
 
public class EPiggyBank implements ActionListener {
 
  public static void main(String[] args) {
    new EPiggyBank();
  }
 
  private JFrame f;
  private JTextField inputField;
  private JLabel amount;
  private JLabel balanceLabel;
  private JLabel totalBalance;
  private int balance = 0;
  private BufferedWriter writer;
 
  //Constructor method to create an object of the class and initialize its instance variables.
  public EPiggyBank() {
    
    //Create frame
    f = new JFrame("E-Piggy");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(400, 400);
    f.setFont(new Font("Arial", Font.BOLD, 18));
    f.setLayout(null);
    f.setResizable(false);
 
    //panel that contains all the components
    JPanel panel1 = new JPanel();
    panel1.setSize(400, 600);
    panel1.setLayout(null);
 
    //Create a JLabel with an object named "Amount"
    amount = new JLabel("Amount:");
    amount.setHorizontalAlignment(SwingConstants.CENTER);
    amount.setLayout(null);
    amount.setBounds(50, 50, 75, 40);
    amount.setBackground(Color.black);
    amount.setBorder(BorderFactory.createLineBorder(Color.BLACK));
 
    //JTextField to accepts the user's input with an object named "inputField"
    inputField = new JTextField(10);
    inputField.setHorizontalAlignment(SwingConstants.CENTER);
    inputField.setLayout(null);
    inputField.setBounds(140, 50, 200, 40);
    inputField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
 
    //JButton that functions as a "Deposit" button
    JButton depositButton = new JButton("Deposit");
    depositButton.setLayout(null);
    depositButton.setBounds(210, 120, 130, 40);
    depositButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    depositButton.setFocusable(false);
 
    //JButton that functions as a "Withdraw" button
    JButton withdrawButton = new JButton("Withdraw");
    withdrawButton.setLayout(null);
    withdrawButton.setBounds(50, 120, 130, 40);
    withdrawButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    withdrawButton.setFocusable(false);
 
    //JLabel for the balance label "Current balance:"
    balanceLabel = new JLabel("Current balance:");
    balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
    balanceLabel.setLayout(null);
    balanceLabel.setBounds(50, 190, 290, 40);
    balanceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
 
    //JLabel for the total balance
    totalBalance = new JLabel("" + balance);
    totalBalance.setHorizontalAlignment(SwingConstants.CENTER);
    totalBalance.setLayout(null);
    totalBalance.setBounds(50, 250, 290, 40);
    totalBalance.setBorder(BorderFactory.createLineBorder(Color.BLACK));
 
    //Adding all the components
    panel1.add(amount);
    panel1.add(inputField);
    panel1.add(depositButton);
    panel1.add(withdrawButton);
    panel1.add(balanceLabel);
    panel1.add(totalBalance);
 
    //Snippet to register the current object
    depositButton.addActionListener(this);
    withdrawButton.addActionListener(this);
 
    f.add(panel1);                     //add the panel
    f.setLocationRelativeTo(null);   //To make the GUI appear on the center of the screen when the program runs 
    f.setVisible(true);              //To make the frame visible
 
    //Open the file writer
    //creating a new instance of a BufferedWriter class to write to a file called "transactions.txt" that contains all of the user's history for withdrawing and depositing with time and date
    try {
      writer = new BufferedWriter(new FileWriter("transactions.txt", true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
 
  @Override
  public void actionPerformed(ActionEvent e) {
    int amount = Integer.parseInt(inputField.getText());
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
  
    // Load the previous balance from a file
    balance = loadBalanceFromFile();
  
    // Set the initial balance in the GUI
    totalBalance.setText("" + balance);
  
    // Conditional statement
    if (e.getActionCommand().equals("Deposit")) {
      balance += amount;
      totalBalance.setText("" + balance);
      inputField.setText("");
      try {
        FileWriter writer = new FileWriter("transactionsHistory.txt", true);
        writer.write("Deposit: " + "₱ "  + amount + " (" + dateFormat.format(now) + ")\n");
        writer.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    } else {
      if (balance >= amount) {
        balance -= amount;
        totalBalance.setText("" + balance);
        inputField.setText("");
        try {
          FileWriter writer = new FileWriter("transactionsHistory.txt", true);
          writer.write("Withdrawal: " + "₱ "  + amount + " (" + dateFormat.format(now) + ")\n");
          writer.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      } else {
        JOptionPane.showMessageDialog(f, "Insufficient funds!");
      }
    }
  
    // Save the updated balance to a file
    saveBalanceToFile(balance);
  }
  
  private int loadBalanceFromFile() {
    try {
      File file = new File("balance.txt");
      if (!file.exists()) {
        return 0;
      }
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = reader.readLine();
      reader.close();
      return Integer.parseInt(line);
    } catch (IOException e) {
      e.printStackTrace();
      return 0;
    }
  }
  
  private void saveBalanceToFile(int balance) {
    try {
      FileWriter writer = new FileWriter("balance.txt");
      writer.write(String.valueOf(balance));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
