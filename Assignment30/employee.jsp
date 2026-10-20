
<%@ page import="java.sql.*" %>
<%
String url = "jdbc:mysql://localhost:3306/jspcrud";
String dbUser = "root";
String dbPassword = "Tasha@2005";

Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword)) {
    String action = request.getParameter("action");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String department = request.getParameter("department");
    String salary = request.getParameter("salary");

    if ("add".equals(action)) {
        try (PreparedStatement ps = con.prepareStatement(
            "INSERT INTO employees(name, department, salary) VALUES(?,?,?)")) {
            ps.setString(1, name);
            ps.setString(2, department);
            ps.setBigDecimal(3, new java.math.BigDecimal(salary));
            ps.executeUpdate();
        }
    } else if ("update".equals(action)) {
        try (PreparedStatement ps = con.prepareStatement(
            "UPDATE employees SET name=?, department=?, salary=? WHERE id=?")) {
            ps.setString(1, name);
            ps.setString(2, department);
            ps.setBigDecimal(3, new java.math.BigDecimal(salary));
            ps.setInt(4, Integer.parseInt(id));
            ps.executeUpdate();
        }
    } else if ("delete".equals(action)) {
        try (PreparedStatement ps = con.prepareStatement(
            "DELETE FROM employees WHERE id=?")) {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
<h2>Employee Management System</h2>

<form method="post">
    Employee ID (for update/delete): <input type="number" name="id"><br><br>
    Name: <input type="text" name="name"><br><br>
    Department: <input type="text" name="department"><br><br>
    Salary: <input type="number" step="0.01" name="salary"><br><br>
    <button name="action" value="add">Add Employee</button>
    <button name="action" value="update">Update Employee</button>
    <button name="action" value="delete">Delete Employee</button>
</form>

<h3>Employee Records</h3>
<table border="1" cellpadding="8">
<tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>
<%
    try (Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM employees")) {
        while (rs.next()) {
%>
<tr>
<td><%= rs.getInt("id") %></td>
<td><%= rs.getString("name") %></td>
<td><%= rs.getString("department") %></td>
<td><%= rs.getBigDecimal("salary") %></td>
</tr>
<%
        }
    }
%>
</table>
</body>
</html>
<%
} catch (Exception e) {
    out.println("<p>Error: " + e.getMessage() + "</p>");
}
%>
