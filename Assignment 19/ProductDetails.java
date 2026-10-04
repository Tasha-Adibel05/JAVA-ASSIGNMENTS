import java.sql.*;

public class ProductDetails
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/shop";
        String username = "root";
        String password = "Tasha@2005";

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM product";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Product Details:");
            System.out.println("ID\tProduct Name\tQuantity\tPrice");

            while (rs.next())
            {
                System.out.println(
                    rs.getInt("product_id") + "\t" +
                    rs.getString("product_name") + "\t\t" +
                    rs.getInt("quantity") + "\t\t" +
                    rs.getDouble("price")
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