<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>
<h1>Current time is: <%out.write(request.getAttribute("time").toString());%></h1>
<a href="./register.jsp">Go to profile page</a>
</body>
</html>