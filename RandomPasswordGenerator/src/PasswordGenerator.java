import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import javax.swing.*;

public class PasswordGenerator extends JFrame implements ActionListener {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String SPECIAL_CHARS = "!@#$?";
    private static final String DIGITS = "0123456789";
    private static final String PASSWORD_CHARS = CHAR_LOWER + CHAR_UPPER + SPECIAL_CHARS + DIGITS;
    private static final int PASSWORD_LENGTH = 15;

    private JTextField passwordField;
    private JButton generateButton;
    private JButton copyButton;

    public PasswordGenerator() {
        setTitle("Password Generator");
    
        passwordField = new JTextField(20);
        passwordField.setEditable(false);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setBounds(50, 50, 300, 50);
        passwordField.setFont(new Font("Arial", Font.BOLD, 18));
    
        generateButton = new JButton("GENERATE");
        generateButton.addActionListener(this);
        generateButton.setBounds(120, 125, 150, 50);
        generateButton.setFont(new Font("Arial", Font.BOLD, 20));
        generateButton.setFocusable(false);
    
        copyButton = new JButton("COPY");
        copyButton.addActionListener(this);
        copyButton.setBounds(135, 200, 120, 50);
        copyButton.setFont(new Font("Arial", Font.BOLD, 20));
        copyButton.setFocusable(false);
    
        JPanel panel = new JPanel(null);
        panel.add(passwordField);
        panel.add(generateButton);
        panel.add(copyButton);
    
        add(panel);
    
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            String password = generatePassword();
            passwordField.setText(password);
        } else if (e.getSource() == copyButton) {
            StringSelection selection = new StringSelection(passwordField.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
            JOptionPane.showMessageDialog(this, "Password copied to clipboard.");
        }
    }

    private String generatePassword() {
        StringBuilder sb = new StringBuilder();
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        boolean hasDigit = false;

        while (sb.length() < PASSWORD_LENGTH) {
            int index = (int) (Math.random() * PASSWORD_CHARS.length());
            char c = PASSWORD_CHARS.charAt(index);
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (SPECIAL_CHARS.indexOf(c) != -1) {
                hasSpecial = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            sb.append(c);
        }

        if (!hasLower || !hasUpper || !hasSpecial || !hasDigit) {
            return generatePassword();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGenerator();
            }
        });
    }
}
