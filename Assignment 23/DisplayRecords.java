import java.sql.*;
import java.util.Scanner;

public class DisplayRecords
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter MySQL password: ");
        String password = sc.nextLine();

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM student";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nStudent Records:");

            while (rs.next())
            {
                System.out.println("Roll No: " + rs.getInt("roll_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Marks: " + rs.getInt("marks"));
                System.out.println("-------------------------");
            }

            rs.close();
            stmt.close();
            con.close();
            sc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}