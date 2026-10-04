import java.sql.*;
import java.util.Scanner;

public class DisplayEmployees
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter MySQL password: ");
        String password = sc.nextLine();

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM employee";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nEmployee Records:");

            while (rs.next())
            {
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("emp_name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
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