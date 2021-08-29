<%--
  Created by IntelliJ IDEA.
  User: ninhn
  Date: 8/8/2021
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <p>Chào bạn <%out.print(request.getAttribute("age"));%> tuổi</p>
</body>
</html>
