import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class CalculatorGUI implements ActionListener {
    JButton[] buttons = {
            multiplication, subtraction, addition, division, back, modulus, total,
            allClear, dot, value0, value1, value2, value3, value4, value5,
            value6, value7, value8, value9
    };
    public static JPanel panel = new JPanel();
    public static JFrame frame = new JFrame();
    public static JButton multiplication = new JButton("*");
    public static JButton subtraction = new JButton("-");
    public static JButton addition = new JButton("+");
    public static JButton division = new JButton("/");
    public static JButton back = new JButton("<<");
    public static JButton modulus = new JButton("%");
    public static JButton total = new JButton("=");
    public static JButton allClear = new JButton("AC");
    public static JButton dot = new JButton(".");
    public static JButton value1 = new JButton("1");
    public static JButton value2 = new JButton("2");
    public static JButton value3 = new JButton("3");
    public static JButton value4 = new JButton("4");
    public static JButton value5 = new JButton("5");
    public static JButton value6 = new JButton("6");
    public static JButton value7 = new JButton("7");
    public static JButton value8 = new JButton("8");
    public static JButton value9 = new JButton("9");
    public static JButton value0 = new JButton("0");

    JTextField input = new JTextField();

    public CalculatorGUI() {
        panel.setBackground(Color.DARK_GRAY);
        frame.setVisible(true);
        frame.setSize(420, 620);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(false);
        panel.setLayout(null);
        frame.setLocationRelativeTo(null);
        input.setBounds(10, 80, 380, 100);
        panel.add(input);
        input.setBackground(Color.LIGHT_GRAY);
        addListeners();
    }

    private void addListeners() {
        for (JButton button : buttons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setBackground(Color.ORANGE);
            button.setForeground(Color.white);
            button.setFocusable(false);
        }
    }

    public static void Calculator() {
        value0.setBounds(10, 480, 145, 70);
        panel.add(value0);
        dot.setBounds(160, 480, 70, 70);
        panel.add(dot);
        back.setBounds(235, 480, 70, 70);
        panel.add(back);
        value1.setBounds(10, 400, 70, 70);
        panel.add(value1);
        value2.setBounds(85, 400, 70, 70);
        panel.add(value2);
        value3.setBounds(160, 400, 70, 70);
        panel.add(value3);
        value4.setBounds(10, 320, 70, 70);
        panel.add(value4);
        value5.setBounds(85, 320, 70, 70);
        panel.add(value5);
        value6.setBounds(160, 320, 70, 70);
        panel.add(value6);
        value7.setBounds(10, 240, 70, 70);
        panel.add(value7);
        value8.setBounds(85, 240, 70, 70);
        panel.add(value8);
        value9.setBounds(160, 240, 70, 70);
        panel.add(value9);
        multiplication.setBounds(235, 240, 70, 70);
        panel.add(multiplication);
        addition.setBounds(310, 240, 70, 70);
        panel.add(addition);
        division.setBounds(235, 320, 70, 70);
        panel.add(division);
        subtraction.setBounds(310, 320, 70, 70);
        panel.add(subtraction);
        modulus.setBounds(235, 400, 70, 70);
        panel.add(modulus);
        total.setBounds(310, 480, 70, 70);
        panel.add(total);
        allClear.setBounds(310, 400, 70, 70);
        panel.add(allClear);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();
        String currentText = input.getText();

        if (e.getSource() == allClear)
            input.setText("");
        else if (e.getSource() == back) {
            if(!currentText.isEmpty())
                input.setText(currentText.substring(0, currentText.length() - 1));
        }

        else if (e.getSource() == total) {
            if (currentText.contains("+")) {
                String[] parts = currentText.split("\\+");
                double total = 0;
                for (String part : parts) {
                    try {
                        if (part.contains("."))
                            total +=  Double.parseDouble(part);
                        else
                            total += Integer.parseInt(part);
                    } catch (NumberFormatException s) {
                        JOptionPane.showMessageDialog(null,"ERROR");
                        return;
                    }
                }
                if (total == (int) total)
                    input.setText(Integer.toString((int) total));
                else
                    input.setText(Double.toString(total));
            }
            else if (currentText.contains("/")) {
                String[] parts = currentText.split("/");
                double total = Double.parseDouble(parts[0]);
                for (int i = 1; i < parts.length; i++) {
                    try {
                        double divide = Double.parseDouble(parts[i]);
                        if (divide == 0) {
                        JOptionPane.showMessageDialog(null,"ERROR");
                        return;
                        }
                        total /= divide;
                    } catch (NumberFormatException s) {
                        JOptionPane.showMessageDialog(null,"ERROR");
                        return;
                    }
                }
                input.setText(Double.toString(total));
            }
            else if (currentText.contains("*")) {
                String[] parts = currentText.split("\\*");
                double total = Double.parseDouble(parts[0]);
                for (int i = 1; i < parts.length; i++) {
                    try {
                        double multiply = Double.parseDouble(parts[i]);
                        total *= multiply;
                    } catch (NumberFormatException s) {
                        JOptionPane.showMessageDialog(null,"ERROR");
                        return;
                    }
                }
                input.setText(Double.toString(total));
            }
            else if (currentText.contains("-")) {
                String[] parts = currentText.split("-");
                double total = Double.parseDouble(parts[0]);
                for (int i = 1; i < parts.length; i++) {
                    try {
                        double subtract = Double.parseDouble(parts[i]);
                        total -= subtract;
                    } catch (NumberFormatException s) {
                        JOptionPane.showMessageDialog(null,"ERROR");
                        return;
                    }
                }
                input.setText(Double.toString(total));
            }
            else if (currentText.contains("%")) {
                try {
                    String[] parts = currentText.split("%");
                    double total = Double.parseDouble(parts[0]);
                    for (int i = 1; i < parts.length; i++) {
                        try {
                            double modulus = Double.parseDouble(parts[i]);
                            total %= modulus;
                        } catch (NumberFormatException s) {
                            JOptionPane.showMessageDialog(null, "ERROR");
                            return;
                        }
                    }
                    input.setText(Double.toString(total));
                }
                catch (NumberFormatException s) {
                        JOptionPane.showMessageDialog(null,"ERROR");
                        return;
                    }
            }
        }
        else
            input.setText(input.getText() + buttonText);

    }
}
