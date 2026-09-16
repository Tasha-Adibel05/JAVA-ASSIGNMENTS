import javax.swing.*;
import java.awt.*;

public class StudentRegistration {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel rollLabel = new JLabel("Roll No:");
        JTextField rollField = new JTextField();

        JLabel courseLabel = new JLabel("Course:");
        JTextField courseField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JButton submitButton = new JButton("Submit");

        frame.setLayout(new GridLayout(5, 2, 10, 10));

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(rollLabel);
        frame.add(rollField);

        frame.add(courseLabel);
        frame.add(courseField);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(new JLabel(""));
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Student Registration Successful!\n" +
                    "Name: " + nameField.getText() + "\n" +
                    "Roll No: " + rollField.getText() + "\n" +
                    "Course: " + courseField.getText() + "\n" +
                    "Email: " + emailField.getText());
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}