import java.sql.*;
import java.util.Scanner;

public class HospitalLogin
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "Tasha@2005";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM staff WHERE login_id = ? AND password = ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, loginId);
            pstmt.setString(2, pass);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                String role = rs.getString("role");

                System.out.println("Authentication successful.");
                System.out.println("Welcome " + role + ".");
                System.out.println("Access granted.");
            }
            else
            {
                System.out.println("Invalid Login ID or Password.");
                System.out.println("Access denied.");
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