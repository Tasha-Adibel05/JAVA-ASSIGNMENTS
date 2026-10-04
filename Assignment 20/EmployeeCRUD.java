import java.sql.*;

public class EmployeeCRUD
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Tasha@2005";

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String insertQuery =
                "INSERT INTO employee VALUES (104, 'Rahul', 'Finance', 42000)";

            stmt.executeUpdate(insertQuery);
            System.out.println("Record inserted successfully.");

            String updateQuery =
                "UPDATE employee SET salary = 48000 WHERE emp_id = 101";

            stmt.executeUpdate(updateQuery);
            System.out.println("Record updated successfully.");

            String deleteQuery =
                "DELETE FROM employee WHERE emp_id = 103";

            stmt.executeUpdate(deleteQuery);
            System.out.println("Record deleted successfully.");

            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            System.out.println("\nEmployee Records:");
            System.out.println("ID\tName\tDepartment\tSalary");

            while (rs.next())
            {
                System.out.println(
                    rs.getInt("emp_id") + "\t" +
                    rs.getString("emp_name") + "\t" +
                    rs.getString("department") + "\t\t" +
                    rs.getDouble("salary")
                );
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}