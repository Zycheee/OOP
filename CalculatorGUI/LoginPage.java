import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {
    public static JPanel panel = new JPanel();
    public static JFrame frame = new JFrame();
    public static JFrame frame2 = new JFrame();
    public static JButton button = new JButton("Login");
    JLabel user = new JLabel("Username: ");
    JTextField userTextField = new JTextField();
    JLabel password = new JLabel("Password: ");
    JPasswordField passwordField = new JPasswordField();

    public void page() {
        frame.setVisible(true);
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(false);
        panel.setLayout(null);
        button.setBounds(150, 220, 120, 40);
        panel.add(button);
        frame.setFocusable(false);
        frame.setLocationRelativeTo(null);
        button.addActionListener(this);
    }

    public void getInfo() {
        user.setBounds(100, 120, 80, 25);
        panel.add(user);
        userTextField.setBounds(180, 120, 125, 30);
        panel.add(userTextField);
        password.setBounds(100, 160, 80, 25);
        panel.add(password);
        passwordField.setBounds(180, 160, 125, 30);
        panel.add(passwordField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = String.valueOf(passwordField.getPassword());
        if (e.getSource() == button) {
            if (userTextField.getText().equals("admin")) {
                JOptionPane.showMessageDialog(null,"Login successfully.");
                if (password.equals("1234")) {
                frame.dispose();
                CalculatorGUI calculator = new CalculatorGUI();
                CalculatorGUI.Calculator();
                }
            }
        }
    }
}

