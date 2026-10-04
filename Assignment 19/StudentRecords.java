import java.sql.*;

public class StudentRecords
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

            String query = "SELECT * FROM student";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Student Records:");
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