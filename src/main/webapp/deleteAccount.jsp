<%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 9/28/2023
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ControlServlet" method="post">
    <h2>Delete Account</h2>
    <form action="ControllerServlet" method="post">
    <p>Insert id want to delete: </p>
    <label for="account_id">Account ID:</label>
    <input type="text" id="account_id" name="account_id" required maxlength="50"><br><br>
    <input type="hidden" name="action" value="deleteAccount">
    <input type="submit" name="deleteAccount" value="deleteAccount">
</form>
</form>
</body>
</html>
