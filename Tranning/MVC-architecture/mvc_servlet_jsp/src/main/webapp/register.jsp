<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register form</title>
</head>
<body>
<div>
<h1>Register</h1>
	<form action="./register" method="post">
		<label> User-name or email address: </label><br> 
		<input type="text" name="name"/> <br>
		<label> Password: </label><br> 
		<input type="password" name="password"/> <br>
		<input type="submit" value="register"/>
	</form>
</div>
</body>
</html>