import java.awt.*;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;

public class LibraryManagement extends JFrame {

    JTextField bookId, bookName, author;
    JTextArea output;
    String password;

    // MySQL connection details
    private static final String URL =
            "jdbc:mysql://localhost:3306/library_gui";
    private static final String USER = "root";

    public LibraryManagement(String password) {

        this.password = password;

        setTitle("Library Management System");
        setSize(600, 500);
        setLayout(new FlowLayout());

        bookId = new JTextField(20);
        bookName = new JTextField(20);
        author = new JTextField(20);

        JButton addButton = new JButton("Add Book");
        JButton displayButton = new JButton("Display Books");

        output = new JTextArea(15, 45);
        output.setEditable(false);

        add(new JLabel("Book ID:"));
        add(bookId);

        add(new JLabel("Book Name:"));
        add(bookName);

        add(new JLabel("Author:"));
        add(author);

        add(addButton);
        add(displayButton);

        add(new JScrollPane(output));

        addButton.addActionListener(e -> addBook());
        displayButton.addActionListener(e -> displayBooks());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Add a book
    void addBook() {

        String id = bookId.getText();
        String name = bookName.getText();
        String auth = author.getText();

        if (id.isEmpty() || name.isEmpty() || auth.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields."
            );
            return;
        }

        String sql =
                "INSERT INTO books (book_id, book_name, author) VALUES (?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(
                    URL, USER, password
            );

            PreparedStatement pstmt = con.prepareStatement(sql)
        ) {

            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.setString(2, name);
            pstmt.setString(3, auth);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Book added successfully!"
            );

            bookId.setText("");
            bookName.setText("");
            author.setText("");

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Book ID must be a number."
            );

        } catch (SQLIntegrityConstraintViolationException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Book ID already exists."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n" + e.getMessage()
            );
        }
    }

    // Display all books
    void displayBooks() {

        String sql = "SELECT book_id, book_name, author FROM books";

        try (
            Connection con = DriverManager.getConnection(
                    URL, USER, password
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql)
        ) {

            output.setText("");

            while (rs.next()) {

                output.append(
                        "Book ID: " +
                        rs.getInt("book_id") +
                        "\n"
                );

                output.append(
                        "Book Name: " +
                        rs.getString("book_name") +
                        "\n"
                );

                output.append(
                        "Author: " +
                        rs.getString("author") +
                        "\n"
                );

                output.append(
                        "-----------------------------\n"
                );
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n" + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        try {

            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter MySQL password: ");
            String password = sc.nextLine();

            // Test database connection
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    password
            );

            System.out.println(
                    "Database connected successfully!"
            );

            con.close();

            // Open GUI
            SwingUtilities.invokeLater(() ->
                    new LibraryManagement(password)
            );

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "MySQL JDBC Driver not found."
            );

            System.out.println(
                    "Make sure mysql-connector-j-26.7.0.jar " +
                    "is added to your project."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Database connection failed!"
            );

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}