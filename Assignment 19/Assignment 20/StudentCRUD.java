import java.sql.*;

public class StudentCRUD
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

            Statement stmt = con.createStatement();

            String insertQuery =
                "INSERT INTO student VALUES (104, 'Rahul', 'CSE', 82)";

            stmt.executeUpdate(insertQuery);
            System.out.println("Record inserted successfully.");

            String updateQuery =
                "UPDATE student SET marks = 95 WHERE roll_no = 102";

            stmt.executeUpdate(updateQuery);
            System.out.println("Record updated successfully.");

            String deleteQuery =
                "DELETE FROM student WHERE roll_no = 103";

            stmt.executeUpdate(deleteQuery);
            System.out.println("Record deleted successfully.");

            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            System.out.println("\nStudent Records:");
            System.out.println("Roll No\tName\tDepartment\tMarks");

            while (rs.next())
            {
                System.out.println(
                    rs.getInt("roll_no") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("department") + "\t\t" +
                    rs.getInt("marks")
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