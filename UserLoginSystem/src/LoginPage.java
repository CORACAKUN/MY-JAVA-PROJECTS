import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener{
	
	JFrame frame = new JFrame();
    JPanel panel = new JPanel();
	JButton loginButton = new JButton("Login");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("username:");
	JLabel userPasswordLabel = new JLabel("password:");
    JLabel logInLabel = new JLabel("Log in");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
        logInLabel.setBounds(40, -5, 60, 50);
        logInLabel.setOpaque(true);
        logInLabel.setFont(new Font("Arial", Font.BOLD, 20));
        logInLabel.setLayout(null);

		userIDLabel.setBounds(30,70,75,25);
		userPasswordLabel.setBounds(30,130,75,25);
		
		messageLabel.setBounds(140,260,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,12));
		
		userIDField.setBounds(100,70,200,25);
		userPasswordField.setBounds(100,130,200,25);
		
		loginButton.setBounds(120,170,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
        panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        panel.setLayout(null);
        panel.setBounds(20, 20, 340, 240 );
		
		panel.add(userIDLabel);
		panel.add(userPasswordLabel);
		panel.add(userIDField);
		panel.add(userPasswordField);
		panel.add(loginButton);
        frame.add(logInLabel);
        frame.add(panel);
        frame.add(messageLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,320);
        frame.setOpacity(1);
        frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.black);
					messageLabel.setText("Login successful");
                    frame.setSize(400,340);
					frame.dispose();
					new WelcomePage(userID);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
                    frame.setSize(400,340);
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("username not found");
                frame.setSize(400,340);
			} 
		}
	}	
}