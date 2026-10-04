import java.awt.*;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;

public class BookIssueTracking extends JFrame
{
    JTextField bookId, studentName, issueDate, returnDate;
    JTextArea output;
    String password;

    public BookIssueTracking(String password)
    {
        this.password = password;

        setTitle("Book Issue Tracking System");
        setSize(550, 500);
        setLayout(new FlowLayout());

        bookId = new JTextField(20);
        studentName = new JTextField(20);
        issueDate = new JTextField(20);
        returnDate = new JTextField(20);

        JButton issueButton = new JButton("Issue Book");
        JButton displayButton = new JButton("Display Records");

        output = new JTextArea(15, 45);

        add(new JLabel("Book ID:"));
        add(bookId);

        add(new JLabel("Student Name:"));
        add(studentName);

        add(new JLabel("Issue Date:"));
        add(issueDate);

        add(new JLabel("Return Date:"));
        add(returnDate);

        add(issueButton);
        add(displayButton);
        add(new JScrollPane(output));

        issueButton.addActionListener(e -> issueBook());
        displayButton.addActionListener(e -> displayRecords());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void issueBook()
    {
        try
        {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/book_issue",
                "root",
                password
            );

            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO book_issue VALUES (?, ?, ?, ?)"
            );

            pstmt.setInt(1, Integer.parseInt(bookId.getText()));
            pstmt.setString(2, studentName.getText());
            pstmt.setString(3, issueDate.getText());
            pstmt.setString(4, returnDate.getText());

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                "Book issue record added successfully."
            );

            pstmt.close();
            con.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void displayRecords()
    {
        try
        {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/book_issue",
                "root",
                password
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM book_issue"
            );

            output.setText("");

            while (rs.next())
            {
                output.append(
                    "Book ID: " + rs.getInt("book_id") +
                    "\nStudent Name: " + rs.getString("student_name") +
                    "\nIssue Date: " + rs.getString("issue_date") +
                    "\nReturn Date: " + rs.getString("return_date") +
                    "\n--------------------------\n"
                );
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter MySQL password: ");
        String password = sc.nextLine();

        new BookIssueTracking(password);
    }
}