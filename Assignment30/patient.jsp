
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
    String age = request.getParameter("age");
    String disease = request.getParameter("disease");
    String status = request.getParameter("status");

    if ("add".equals(action)) {
        try (PreparedStatement ps = con.prepareStatement(
            "INSERT INTO patients(name, age, disease, treatment_status) VALUES(?,?,?,?)")) {
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(age));
            ps.setString(3, disease);
            ps.setString(4, status);
            ps.executeUpdate();
        }
    } else if ("update".equals(action)) {
        try (PreparedStatement ps = con.prepareStatement(
            "UPDATE patients SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?")) {
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(age));
            ps.setString(3, disease);
            ps.setString(4, status);
            ps.setInt(5, Integer.parseInt(id));
            ps.executeUpdate();
        }
    } else if ("delete".equals(action)) {
        try (PreparedStatement ps = con.prepareStatement(
            "DELETE FROM patients WHERE patient_id=?")) {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Management</title>
</head>
<body>
<h2>Patient Record Management System</h2>

<form method="post">
    Patient ID (for update/delete): <input type="number" name="id"><br><br>
    Name: <input type="text" name="name"><br><br>
    Age: <input type="number" name="age"><br><br>
    Disease: <input type="text" name="disease"><br><br>
    Treatment Status: <input type="text" name="status"><br><br>
    <button name="action" value="add">Add Patient</button>
    <button name="action" value="update">Update Patient</button>
    <button name="action" value="delete">Delete Patient</button>
</form>

<h3>Patient Records</h3>
<table border="1" cellpadding="8">
<tr><th>ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th></tr>
<%
    try (Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM patients")) {
        while (rs.next()) {
%>
<tr>
<td><%= rs.getInt("patient_id") %></td>
<td><%= rs.getString("name") %></td>
<td><%= rs.getInt("age") %></td>
<td><%= rs.getString("disease") %></td>
<td><%= rs.getString("treatment_status") %></td>
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
