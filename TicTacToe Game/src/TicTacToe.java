import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new TicTacToe();
    }

    JButton[][] buttons = new JButton[3][3];
    int[][] board = new int[3][3];
    int player = 1;

    public TicTacToe() {
        
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));
        setResizable(false);

        // Center the JFrame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) (screenSize.getWidth() - getWidth()) / 2;
        int centerY = (int) (screenSize.getHeight() - getHeight()) / 2;
        setLocation(centerX, centerY);

    // Create a font with size 24 and style BOLD
    Font font = new Font("Arial", Font.BOLD, 24);    

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBackground(Color.BLACK);
                buttons[i][j].setForeground(Color.WHITE);
                buttons[i][j].setFont(font);
                buttons[i][j].setFocusPainted(false);
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }


    public boolean checkForWin(int player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
    
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
    
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
    
        return false;
    }

    public boolean checkForTie() {
        // Check if all spaces are filled
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false; // There is an empty space, so the game is not a tie
                }
            }
        }
    
        // If we get here, all spaces are filled and neither player has won
        return true; // It's a tie!
    }

    public void resetGame() {
        // Reset board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
                buttons[i][j].setText("");
            }
        }
    
        // Reset player
        player = 1;
    }

    // functions for each array buttons
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton)e.getSource();
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttonClicked == buttons[i][j]) {
                    if (board[i][j] == 0) {
                        board[i][j] = player;
                        if (player == 1) {
                            buttonClicked.setText("X");
                            if (checkForWin(1)) {
                                JOptionPane.showMessageDialog(this, "Player 1 wins!");
                                resetGame();
                            }
                            player = 2;
                        } else {
                            buttonClicked.setText("O");
                            if (checkForWin(2)) {
                                JOptionPane.showMessageDialog(this, "Player 2 wins!");
                                resetGame();
                            } else if (checkForTie()) {
                                JOptionPane.showMessageDialog(this, "Tie!");
                                resetGame();
                            }
                            player = 1;
                        }
                    }
                }
            }
        }
    }
}
