import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyListenerExample implements KeyListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("KeyListener Example");
        JPanel panel = new JPanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(new KeyListenerExample());
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key Pressed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Key Released: " + e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyChar());
    }
}