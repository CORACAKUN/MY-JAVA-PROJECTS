import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyMethods implements MouseListener {

    private JLabel lbl;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;

    private int mouseEnteredCount;

    public MyMethods(JLabel lbl, JLabel lbl2, JLabel lbl3, JLabel lbl4, JLabel lbl5) {
        this.lbl = lbl;
        this.lbl2 = lbl2;
        this.lbl3 = lbl3;
        this.lbl4 = lbl4;
        this.lbl5 = lbl5;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Mouse pressed event handling
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseEnteredCount++;

        lbl.setBackground(Color.RED);
        lbl2.setBackground(Color.RED);
        lbl3.setBackground(Color.RED);
        lbl4.setBackground(Color.RED);
        lbl5.setBackground(Color.RED);
        System.out.println("Mouse entered! " + mouseEnteredCount );

        boolean gameOver = true;
        if ( gameOver ) {
            GameAlert.showGameOverAlert();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }



}