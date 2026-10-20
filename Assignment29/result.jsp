
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <h2>Registration Successful</h2>

    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
    %>

    Name: <%= name %><br><br>
    Email: <%= email %><br><br>
    Phone Number: <%= phone %><br><br>
    Password: <%= password %><br><br>

    <a href="register.jsp">Back to Registration</a>
</body>
</html>
