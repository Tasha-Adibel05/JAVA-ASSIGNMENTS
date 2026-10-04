import java.sql.*;
import java.util.Scanner;

public class LoginApplication
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/login_db";
        String username = "root";
        String password = "Tasha@2005";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, user);
            pstmt.setString(2, pass);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                System.out.println("Login successful.");
                System.out.println("Welcome " + rs.getString("username"));
            }
            else
            {
                System.out.println("Invalid username or password.");
            }

            rs.close();
            pstmt.close();
            con.close();
            sc.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}