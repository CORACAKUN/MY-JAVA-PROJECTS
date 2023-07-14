import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
    
    private JLabel lbl;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;
    private JButton winBtn;
    private MyMethods myMethods;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 750, 500 );
        this.setLocationRelativeTo( null );
        this.setLayout( null );

        lbl = new JLabel("Putang ina mo");
        lbl.setBounds( 150, 0, 750, 75 );
        lbl.setBackground(Color.BLACK);
        lbl.setForeground(Color.black);
        lbl.setOpaque(true);

        lbl2 = new JLabel();
        lbl2.setBounds( 0, 390, 600, 75 );
        lbl2.setBackground(Color.BLACK);
        lbl2.setOpaque(true);

        lbl3 = new JLabel();
        lbl3.setBounds( 150, 75, 75, 250 );
        lbl3.setBackground(Color.BLACK);
        lbl3.setOpaque(true);

        lbl4 = new JLabel();
        lbl4.setBounds( 525, 150, 75, 250 );
        lbl4.setBackground(Color.BLACK);
        lbl4.setOpaque(true);

        lbl5 = new JLabel();
        lbl5.setBounds( 300, 165, 150, 150 );
        lbl5.setBackground(Color.BLACK);
        lbl5.setOpaque(true);

        myMethods = new MyMethods(lbl, lbl2, lbl3, lbl4, lbl5);
        lbl.addMouseListener(myMethods);
        lbl2.addMouseListener(myMethods);
        lbl3.addMouseListener(myMethods);
        lbl4.addMouseListener(myMethods);
        lbl5.addMouseListener(myMethods);

        winBtn = new JButton("Goal");
        winBtn.setBounds( 0, 0, 150, 100 );
        winBtn.setFocusable(false);

        this.add(lbl);
        this.add(lbl2);
        this.add(lbl3);
        this.add(lbl4);
        this.add(lbl5);
        this.add(winBtn);


    }
}
