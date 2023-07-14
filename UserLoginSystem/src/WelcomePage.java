import java.awt.*;
import javax.swing.*;

public class WelcomePage {

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	
	WelcomePage(String userID){
		
		welcomeLabel.setBounds(30,100,300,60);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome "+userID);

		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320, 320);
		frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
		frame.setVisible(true);
	}

    public static void main (String[] args) {
        new WelcomePage(null);
    }
}