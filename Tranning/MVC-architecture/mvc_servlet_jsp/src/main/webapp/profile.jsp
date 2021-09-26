<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="mvc_demo.profileModel" %>
<%
	profileModel profile = (profileModel) request.getAttribute("model");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
</head>
<body>
	<h1>This is your profile page</h1>
	<h2>Name: <% out.write(profile.getName());%></h2>
	<h2>Age: <% out.write(profile.getAge());%></h2>
	<h2>Major: <% out.write(profile.getMajor());%></h2>
	<h2>Exp: <% out.write(profile.getExp());%></h2>
	<h2>Hire: <% out.write(profile.getHire());%></h2>
</body>
</html>