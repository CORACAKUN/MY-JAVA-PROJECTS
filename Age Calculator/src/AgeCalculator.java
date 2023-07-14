import javax.swing.*;
import javax.swing.border.AbstractBorder;

import java.awt.*;
import java.awt.event.*;

public class AgeCalculator {
    private JFrame frame;
    private JPanel panel;
    private JLabel birthdayLabel;
    private JComboBox<Integer> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> yearComboBox;
    private JLabel currentDateLabel;
    private JComboBox<Integer> currentDayComboBox;
    private JComboBox<String> currentMonthComboBox;
    private JComboBox<Integer> currentYearComboBox;
    private JButton calculateButton;
    private JButton clearButton;

    public AgeCalculator() {
        frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize( 450, 450 );
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Age Calculator");
        titleLabel.setBounds( 10, 10 , 415, 50 );
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(new Font("Rajdhani", Font.BOLD, 25));
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        titleLabel.setOpaque(true);
        panel.add(titleLabel);        
        setLabelFont(titleLabel, 25 );

        int arcSize = 20;
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                new RoundBorder(arcSize),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        birthdayLabel = new JLabel("BIRTHDAY: ");
        birthdayLabel.setBounds(5, 75, 200, 50 );
        panel.add(birthdayLabel);
        setLabelFont(birthdayLabel, 19 );


        dayComboBox = new JComboBox<Integer>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        dayComboBox.setBounds(155, 130, 120, 50 );
        dayComboBox.setBackground(Color.white);
        dayComboBox.setOpaque(true);
        panel.add(dayComboBox);

        monthComboBox = new JComboBox<String>(new String[] {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        });
        monthComboBox.setBounds(20, 130,120, 50 );
        monthComboBox.setBackground(Color.white);
        monthComboBox.setOpaque(true);
        panel.add(monthComboBox);

        yearComboBox = new JComboBox<Integer>();
        for (int i = 1900; i <= 2023; i++) {
            yearComboBox.addItem(i);
        }
        yearComboBox.setBounds(290, 130, 120, 50 );
        yearComboBox.setBackground(Color.white);
        yearComboBox.setOpaque(true);
        panel.add(yearComboBox);

        currentDateLabel = new JLabel("DATE TODAY: ");
        currentDateLabel.setBounds( 5, 180, 200, 50 );
        setLabelFont(currentDateLabel, 19 );
        panel.add(currentDateLabel);

        currentDayComboBox = new JComboBox<Integer>();
        for (int i = 1; i <= 31; i++) {
            currentDayComboBox.addItem(i);
        }
        currentDayComboBox.setBounds(155, 230, 120, 50 );
        currentDayComboBox.setBackground(Color.white);
        currentDayComboBox.setOpaque(true);
        panel.add(currentDayComboBox);

        currentMonthComboBox = new JComboBox<String>(new String[] {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        });
        currentMonthComboBox.setBounds(20, 230, 120, 50 );
        currentMonthComboBox.setBackground(Color.white);
        currentMonthComboBox.setOpaque(true);
        panel.add(currentMonthComboBox);

        currentYearComboBox = new JComboBox<Integer>();
        for (int i = 1900; i <= 2023; i++) {
            currentYearComboBox.addItem(i);
        }
        currentYearComboBox.setBounds( 290, 230, 120, 50 );
        currentYearComboBox.setBackground(Color.white);
        currentYearComboBox.setOpaque(true);        
        panel.add(currentYearComboBox);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });
        calculateButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        calculateButton.setBackground(Color.white);
        calculateButton.setBounds(75, 330, 120, 35 );
        calculateButton.setFocusable(false);
        panel.add(calculateButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearInput();
            }
        });
        clearButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        clearButton.setBounds(230, 330, 120, 35 );
        clearButton.setBackground(Color.white);
        clearButton.setFocusable(false);
        panel.add(clearButton);
        

        frame.getContentPane().add(panel);
        //frame.pack();
        frame.setVisible(true);
    }

        // Custom border class for creating rounded corners
        private static class RoundBorder extends AbstractBorder {
            private int arcSize;
    
            public RoundBorder(int arcSize) {
                this.arcSize = arcSize;
            }
    
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(c.getForeground());
                g2d.drawRoundRect(x, y, width - 5, height - 5, arcSize, arcSize);
                g2d.dispose();
            }
    
            @Override
            public Insets getBorderInsets(Component c) {
                int borderWidth = 2; // Adjust border width if needed
                return new Insets(borderWidth, borderWidth, borderWidth, borderWidth);
            }
    
            @Override
            public Insets getBorderInsets(Component c, Insets insets) {
                insets.left = insets.right = insets.bottom = insets.top = 2; // Adjust border width if needed
                return insets;
            }
    
            @Override
            public boolean isBorderOpaque() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'isBorderOpaque'");
            }
        }

    // Method to set the font size for a JLabel
    private static void setLabelFont(JLabel label, int fontSize) {
        Font font = new Font(label.getFont().getName(), Font.PLAIN, fontSize);
        label.setFont(font);
    }

    private void calculateAge() {
        int birthDay = (int) dayComboBox.getSelectedItem();
        String birthMonth = (String) monthComboBox.getSelectedItem();
        int birthYear = (int) yearComboBox.getSelectedItem();
    
        int currentDay = (int) currentDayComboBox.getSelectedItem();
        String currentMonth = (String) currentMonthComboBox.getSelectedItem();
        int currentYear = (int) currentYearComboBox.getSelectedItem();
    
        // Perform the age calculation here
        int ageInYears = currentYear - birthYear;
        int ageInMonths = 0;
        int ageInDays = 0;
    
        if (birthMonth.equals(currentMonth) && birthDay <= currentDay) {
            ageInMonths = 0;
            ageInDays = currentDay - birthDay;
        } else {
            int birthMonthIndex = monthComboBox.getSelectedIndex();
            int currentMonthIndex = currentMonthComboBox.getSelectedIndex();
            ageInMonths = currentMonthIndex - birthMonthIndex;
            ageInDays = currentDay;
    
            if (currentMonthIndex < birthMonthIndex) {
                ageInYears--;
                ageInMonths += 12;
            } else if (currentMonthIndex == birthMonthIndex) {
                if (currentDay < birthDay) {
                    ageInYears--;
                    ageInMonths = 11;
                    int daysInBirthMonth = getDaysInMonth(birthMonthIndex, birthYear);
                    ageInDays = daysInBirthMonth - birthDay + currentDay;
                }
            } else {
                int daysInBirthMonth = getDaysInMonth(birthMonthIndex, birthYear);
                ageInDays += daysInBirthMonth - birthDay;
            }
        }
    
        // Create a new frame to display the result
        JFrame resultFrame = new JFrame("Age Calculation Result");
        resultFrame.setSize(400, 350);
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(null);
    
        JLabel yearsOld = new JLabel("Your Age  =  " + " " + Integer.toString(ageInYears) );
        JLabel yearsLabel = new JLabel(": Years old");
        JLabel monthsLabel = new JLabel(": Months old");
        JLabel daysLabel = new JLabel(": Days old"  );

        yearsOld.setFont(new Font("Rajdhani", Font.PLAIN, 20));
        yearsLabel.setFont(new Font("Rajdhani", Font.PLAIN, 20));
        monthsLabel.setFont(new Font("Rajdhani", Font.PLAIN, 20));
        daysLabel.setFont(new Font("Rajdhani", Font.PLAIN, 20));

        yearsOld.setBounds(120, 35, 300, 50 );
        yearsLabel.setBounds(80, 170, 300, 50 );
        monthsLabel.setBounds(220, 170, 300, 50 );
        daysLabel.setBounds(170, 205, 300, 50 );
    
        JLabel yearsResultLabel = new JLabel(Integer.toString(ageInYears));
        JLabel monthsResultLabel = new JLabel(Integer.toString(ageInMonths));
        JLabel daysResultLabel = new JLabel(Integer.toString(ageInDays));

        yearsResultLabel.setBounds(50, 170, 100, 50 );
        monthsResultLabel.setBounds(190, 170, 100, 50 );
        daysResultLabel.setBounds(110, 205, 100, 50 );
 
        yearsResultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        monthsResultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        daysResultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    
        resultPanel.add(yearsOld);
        resultPanel.add(yearsLabel);
        resultPanel.add(yearsResultLabel);
        resultPanel.add(monthsLabel);
        resultPanel.add(monthsResultLabel);
        resultPanel.add(daysLabel);
        resultPanel.add(daysResultLabel);
        
        resultFrame.getContentPane().add(resultPanel);
        resultFrame.setVisible(true);
    }

    private int getDaysInMonth(int month, int year) {
        int daysInMonth;
        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                daysInMonth = 31;
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                daysInMonth = 30;
                break;
            case 2: // February
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                daysInMonth = 0; // Invalid month
                break;
        }
        return daysInMonth;
    }

    private void clearInput() {
        dayComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        currentDayComboBox.setSelectedIndex(0);
        currentMonthComboBox.setSelectedIndex(0);
        currentYearComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AgeCalculator();
            }
        });
    }
}
