import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizForm extends JFrame implements ActionListener {

    JRadioButton q1_opt1, q1_opt2, q1_opt3;
    JCheckBox q2_opt1, q2_opt2, q2_opt3;
    JTextField q3_answer;
    JTextArea q4_answer;
    JButton submitBtn;
    JLabel resultLabel;

    ButtonGroup bg;
    public QuizForm() {
        add(new JLabel("K.Avinash"));
        add(new JLabel("2024503506\n"));
        setTitle("Interactive Quiz Form");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(30,1));

        add(new JLabel("Q1. Which language is used for Android development?"));
        q1_opt1 = new JRadioButton("C++");
        q1_opt2 = new JRadioButton("Java");
        q1_opt3 = new JRadioButton("Python");

        bg = new ButtonGroup();
        bg.add(q1_opt1);
        bg.add(q1_opt2);
        bg.add(q1_opt3);

        add(q1_opt1);
        add(q1_opt2);
        add(q1_opt3);

        add(new JLabel("Q2. Which of the following are OOP principles?"));
        q2_opt1 = new JCheckBox("Encapsulation");
        q2_opt2 = new JCheckBox("Polymorphism");
        q2_opt3 = new JCheckBox("Recursion");

        add(q2_opt1);
        add(q2_opt2);
        add(q2_opt3);

        add(new JLabel("Q3. What is the keyword to inherit a class in Java?"));
        q3_answer = new JTextField(10);
        add(q3_answer);

        add(new JLabel("Q4. Explain what is inheritance (1-2 lines):"));
        q4_answer = new JTextArea(3, 40);
        add(q4_answer);

        submitBtn = new JButton("Submit Quiz");
        add(submitBtn);
        submitBtn.addActionListener(this);

        resultLabel = new JLabel("");
        add(resultLabel);

        setVisible(true);
    }

    public int calculateScore() {
        int score = 0;

        if (q1_opt2.isSelected()) {
            score += 1;
        }

        if (q2_opt1.isSelected() && q2_opt2.isSelected() && !q2_opt3.isSelected()) {
            score += 1;
        }

        if (q3_answer.getText().trim().equalsIgnoreCase("extends")) {
            score += 1;
        }

        String ans4 = q4_answer.getText().toLowerCase();
        if (ans4.contains("inherit") || ans4.contains("reuse")) {
            score += 1;
        }

        return score;
    }

    public void actionPerformed(ActionEvent e) {
        int total = calculateScore();

        String correctAnswers = """
                Correct Answers:
                Q1. Java
                Q2. Encapsulation, Polymorphism
                Q3. extends
                Q4. Inheritance allows a class to use properties of another class.
                """;

        JOptionPane.showMessageDialog(this,
                "Your Total Score: " + total + "/4\n\n" + correctAnswers,
                "Quiz Result",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new QuizForm();
    }
}
