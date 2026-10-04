import java.sql.*;

public class StudentDatabaseConnection
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Tasha@2005";

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection successful.");
            System.out.println("Student database connected successfully.");

            con.close();
        }
        catch (SQLException e)
        {
            System.out.println("Connection failed.");
            System.out.println(e.getMessage());
        }
    }
}