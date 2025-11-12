package JavaGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class GoogleAccountForm extends JFrame implements ActionListener {

    JTextField firstNameField, lastNameField, usernameField, phoneField, recoveryEmailField, dayField, yearField;
    JPasswordField passwordField, confirmPasswordField;
    JComboBox<String> monthBox, genderBox;
    JButton createButton, resetButton, cancelButton;

    public GoogleAccountForm() {
        setTitle("Create your Google Account");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(30,1));
        add(new JLabel("D.Vinesh"));
        add(new JLabel("2024503019"));
        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Recovery Email:"));
        recoveryEmailField = new JTextField();
        add(recoveryEmailField);

        add(new JLabel("Birth Month:"));
        monthBox = new JComboBox<>(new String[]{"Month", "January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"});
        add(monthBox);

        add(new JLabel("Birth Day:"));
        dayField = new JTextField();
        add(dayField);

        add(new JLabel("Birth Year:"));
        yearField = new JTextField();
        add(yearField);

        add(new JLabel("Gender:"));
        genderBox = new JComboBox<>(new String[]{"Select", "Male", "Female", "Other"});
        add(genderBox);

        createButton = new JButton("Create Account");
        resetButton = new JButton("Reset");
        cancelButton = new JButton("Cancel");

        add(createButton);
        add(resetButton);
        add(cancelButton);

        createButton.addActionListener(this);
        resetButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            try {
                validateForm();
                JOptionPane.showMessageDialog(this, "Account created successfully! 🎉");
            } catch (InvalidInputException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == resetButton) {
            resetForm();
        } else if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }

    private void validateForm() throws InvalidInputException {
        String first = firstNameField.getText().trim();
        String last = lastNameField.getText().trim();
        String user = usernameField.getText().trim();
        String pass = new String(passwordField.getPassword());
        String confirm = new String(confirmPasswordField.getPassword());
        String phone = phoneField.getText().trim();
        String recovery = recoveryEmailField.getText().trim();
        String day = dayField.getText().trim();
        String year = yearField.getText().trim();

        if (first.isEmpty() || last.isEmpty() || user.isEmpty() || pass.isEmpty() || confirm.isEmpty()
                || phone.isEmpty() || recovery.isEmpty() || day.isEmpty() || year.isEmpty()
                || monthBox.getSelectedIndex() == 0 || genderBox.getSelectedIndex() == 0) {
            throw new InvalidInputException("All fields must be filled!");
        }

        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher m = emailPattern.matcher(user + "@gmail.com");
        if (!m.matches()) {
            throw new InvalidInputException("Invalid email ID format!");
        }

        if (pass.length() < 8) {
            throw new InvalidInputException("Password must be at least 8 characters long!");
        }
        if (!pass.equals(confirm)) {
            throw new InvalidInputException("Password and Confirm Password do not match!");
        }
    }

    private void resetForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        phoneField.setText("");
        recoveryEmailField.setText("");
        dayField.setText("");
        yearField.setText("");
        monthBox.setSelectedIndex(0);
        genderBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new GoogleAccountForm();
    }
}

