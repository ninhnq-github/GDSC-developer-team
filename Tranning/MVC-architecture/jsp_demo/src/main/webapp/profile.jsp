<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	if (!name.equals("ninh") || !password.equals("123"))
		request.getRequestDispatcher("./index.jsp").forward(request,response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
</head>
<body>
<% for (int i=0; i<10; i++) {%>
	This is your profile page, hello <%out.write(name);%><br>
<%}%>
</body>
</html>