<%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 9/11/2023
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = (String) request.getAttribute("username");
    String password = (String) request.getAttribute("password");
%>

<p>Username: <%= username %></p>
<p>Password: <%= password %></p>
</body>
</html>
