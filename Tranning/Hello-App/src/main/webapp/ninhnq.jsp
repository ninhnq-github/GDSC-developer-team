<%--
  Created by IntelliJ IDEA.
  User: ninhn
  Date: 8/8/2021
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Bạn bao nhiêu tuổi?</h3>
    <form name="submit-form" action="/ninh-servlet" method="post">
          <select name="age">
              <%for (int i=0; i<100; i++){%>
                    <option value="<%out.print(i);%>"><%out.print(i);%> tuổi</option>
              <%}%>
          </select>
          <input name="submit-btn" value="Gửi" type="submit">
    </form>
</body>
</html>
