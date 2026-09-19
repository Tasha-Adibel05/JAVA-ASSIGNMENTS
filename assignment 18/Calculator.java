import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField t1, t2, result;
    JButton add, subtract;

    Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setLayout(new FlowLayout());

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        result = new JTextField(10);
        result.setEditable(false);

        add = new JButton("Add");
        subtract = new JButton("Subtract");

        add(t1);
        add(t2);
        add(add);
        add(subtract);
        add(result);

        add.addActionListener(this);
        subtract.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());

        if (e.getSource() == add)
            result.setText(String.valueOf(a + b));
        else
            result.setText(String.valueOf(a - b));
    }

    public static void main(String[] args) {
        new Calculator();
    }
}