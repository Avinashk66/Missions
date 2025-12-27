import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorUI extends JFrame implements ActionListener {

    JTextField display;
    String operator = "";
    double num1 = 0, num2 = 0;

    public CalculatorUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        }
        else if (cmd.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd;
            display.setText("");
        }
        else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num2 != 0 ? num1 / num2 : 0; break;
            }
            display.setText(String.valueOf(result));
        }
        else if (cmd.equals("C")) {
            display.setText("");
            num1 = num2 = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new CalculatorUI();
    }
}
