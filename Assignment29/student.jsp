
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h2>Enter Student Information</h2>
    <form action="student.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        PRN: <input type="text" name="prn" required><br><br>
        Course: <input type="text" name="course" required><br><br>
        Semester: <input type="text" name="semester" required><br><br>
        <input type="submit" value="Submit">
    </form>

    <%
        String name = request.getParameter("name");
        String prn = request.getParameter("prn");
        String course = request.getParameter("course");
        String semester = request.getParameter("semester");

        if (name != null) {
    %>
        <h2>Student Information</h2>
        Name: <%= name %><br>
        PRN: <%= prn %><br>
        Course: <%= course %><br>
        Semester: <%= semester %>
    <%
        }
    %>
</body>
</html>
