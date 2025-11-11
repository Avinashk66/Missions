import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllSwingComponents extends JFrame implements ActionListener {

    JLabel label, genderLabel, areaLabel, choiceLabel, listLabel, menuLabel;
    JTextField textField;
    JTextArea textArea;
    JCheckBox cb1, cb2, cb3;
    JRadioButton rb1, rb2;
    ButtonGroup genderGroup;
    JComboBox<String> comboBox;
    JList<String> list;
    JButton button, clearBtn;
    JScrollBar scrollBar;
    JMenuBar menuBar;
    JMenu fileMenu, helpMenu;
    JMenuItem openItem, exitItem, aboutItem;
    JPanel panel;

    AllSwingComponents() {
        setTitle("All Swing Components Example");
        setSize(700, 700);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Enter Your Name:");
        add(label);

        textField = new JTextField(15);
        add(textField);

        areaLabel = new JLabel("Enter Address:");
        add(areaLabel);
        textArea = new JTextArea(3, 20);
        add(new JScrollPane(textArea));

        add(new JLabel("Select Hobbies:"));
        cb1 = new JCheckBox("Reading");
        cb2 = new JCheckBox("Gaming");
        cb3 = new JCheckBox("Music");
        add(cb1);
        add(cb2);
        add(cb3);

        genderLabel = new JLabel("Select Gender:");
        add(genderLabel);
        rb1 = new JRadioButton("Male");
        rb2 = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(rb1);
        genderGroup.add(rb2);
        add(rb1);
        add(rb2);

        choiceLabel = new JLabel("Select Course:");
        add(choiceLabel);
        String[] courses = {"C++", "Java", "Python", "HTML"};
        comboBox = new JComboBox<>(courses);
        add(comboBox);

        listLabel = new JLabel("Select Country:");
        add(listLabel);
        String[] countries = {"India", "USA", "UK", "Canada", "Germany"};
        list = new JList<>(countries);
        list.setVisibleRowCount(3);
        add(new JScrollPane(list));

        button = new JButton("Submit");
        clearBtn = new JButton("Clear");
        add(button);
        add(clearBtn);
        button.addActionListener(this);
        clearBtn.addActionListener(this);

        scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 100);
        add(scrollBar);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 80));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(new JLabel("This is a Panel"));
        add(panel);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        openItem = new JMenuItem("Open");
        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");

        fileMenu.add(openItem);
        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        exitItem.addActionListener(e -> System.exit(0));
        aboutItem.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "All Swing Components Example\nCreated by K.Avinash", "About", JOptionPane.INFORMATION_MESSAGE)
        );

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            // Collect form data
            String name = textField.getText();
            String address = textArea.getText();
            String gender = rb1.isSelected() ? "Male" : rb2.isSelected() ? "Female" : "Not selected";
            String hobbies = "";
            if (cb1.isSelected()) hobbies += "Reading ";
            if (cb2.isSelected()) hobbies += "Gaming ";
            if (cb3.isSelected()) hobbies += "Music ";
            String course = (String) comboBox.getSelectedItem();
            String country = list.getSelectedValue();

            JOptionPane.showMessageDialog(this,
                    "Name: " + name +
                            "\nAddress: " + address +
                            "\nGender: " + gender +
                            "\nHobbies: " + hobbies +
                            "\nCourse: " + course +
                            "\nCountry: " + country,
                    "Form Data",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == clearBtn) {
            textField.setText("");
            textArea.setText("");
            genderGroup.clearSelection();
            cb1.setSelected(false);
            cb2.setSelected(false);
            cb3.setSelected(false);
            comboBox.setSelectedIndex(0);
            list.clearSelection();
        }
    }

    public static void main(String[] args) {
        new AllSwingComponents();
    }
}
