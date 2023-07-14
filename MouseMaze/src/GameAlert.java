import javax.swing.JOptionPane;

public class GameAlert {

    private static boolean alertShown = false;

    public static void showGameOverAlert() {
        if ( !alertShown ) {
                    JOptionPane.showMessageDialog( null, "You have lost!", "Game Over ", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
