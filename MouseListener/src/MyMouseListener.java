import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyMouseListener extends JFrame implements MouseListener {

    JLabel label;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;

    private Color[] colors = { Color.BLUE, Color.RED, Color.GREEN, Color.BLACK };
    private int colorIndex = 0;
    private Color originalColor;

    private int clickCount;
    private int pressedCount;
    private int enteredCount;
    private int releasedCount;
    private int exitedCount;

    MyMouseListener() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        label = new JLabel("Mouse click");
        label.setBounds(0, 0, 490, 100);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        originalColor = label.getBackground();
        label.addMouseListener(this);

        label2 = new JLabel("Mouse pressed"); // Fixed variable name
        label2.setBounds(0, 100, 490, 100); // Changed the Y position to avoid overlap
        label2.setOpaque(true);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        originalColor = label2.getBackground(); // Fixed variable name
        label2.addMouseListener(this); // Added mouse listener

        label3 = new JLabel("Mouse entered");
        label3.setBounds(0, 200, 490, 100); 
        label3.setOpaque(true);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        originalColor = label3.getBackground();
        label3.addMouseListener(this);

        label4 = new JLabel("Mouse Releeased");
        label4.setBounds(0, 300, 490, 100);
        label4.setOpaque(true);
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        originalColor = label4.getBackground();
        label4.addMouseListener(this);

        label5 = new JLabel("Mouse Exited");
        label5.setBounds(0, 400, 490, 100);
        label5.setOpaque(true);
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        originalColor = label5.getBackground();
        label5.addMouseListener(this);

        this.add(label);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);

        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == label) {
            label.setBackground(colors[colorIndex]);
            colorIndex = (colorIndex + 1) % colors.length;

            if ( label == e.getSource() ) {
             label.setForeground(Color.white);;
            } else if ( label == e.getSource() ) {
                label.setForeground(Color.yellow);
            }

        clickCount++;
        System.out.println("Mouse clicked: " + clickCount  );
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == label2) {
            label2.setBackground(colors[colorIndex]);
            colorIndex = (colorIndex + 1) % colors.length;

            pressedCount++;
            System.out.println("Moused pressed" + pressedCount );
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if ( e.getSource() == label4 ) {
            label4.setBackground(colors[colorIndex]);
            colorIndex = ( colorIndex + 1 ) % colors.length;

            releasedCount++;
            System.out.println("Mouse released " + releasedCount );
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == label3) {
            label3.setBackground(colors[colorIndex]);
            colorIndex = (colorIndex + 1) % colors.length;

            enteredCount++;
            System.out.println("mouse entered " + enteredCount );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if ( e.getSource() == label5 ) {
            label5.setBackground(colors [colorIndex ]);
            colorIndex = (colorIndex + 1) % colors.length;

            exitedCount++;
            System.out.println("mouse exited: " + exitedCount );
        }
    }

    public static void main(String[] args) {
        new MyMouseListener();
    }
}