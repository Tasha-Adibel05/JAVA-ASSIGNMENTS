import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankBalance extends JFrame implements ActionListener {
    JTextField balance, amount, result;
    JButton deposit, withdraw;

    BankBalance() {
        setTitle("Bank Balance Calculator");
        setSize(400, 300);
        setLayout(new FlowLayout());

        balance = new JTextField(10);
        amount = new JTextField(10);
        result = new JTextField(10);
        result.setEditable(false);

        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");

        add(balance);
        add(amount);
        add(deposit);
        add(withdraw);
        add(result);

        deposit.addActionListener(this);
        withdraw.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double b = Double.parseDouble(balance.getText());
        double a = Double.parseDouble(amount.getText());

        if (e.getSource() == deposit)
            b = b + a;
        else
            b = b - a;

        result.setText(String.valueOf(b));
    }

    public static void main(String[] args) {
        new BankBalance();
    }
}