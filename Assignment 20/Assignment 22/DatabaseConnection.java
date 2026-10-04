import java.sql.*;

public class DatabaseConnection
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

            System.out.println("Database connected successfully.");

            con.close();
        }
        catch (SQLException e)
        {
            System.out.println("Database connection failed.");
            System.out.println(e.getMessage());
        }
    }
}