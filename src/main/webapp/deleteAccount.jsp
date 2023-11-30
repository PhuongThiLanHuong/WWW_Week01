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
    <title>Delete Account</title>
</head>
<style>
    form {
        border: 3px solid #f1f1f1;
    }

    input[type=text] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    button {
        background-color: #04AA6D;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }
</style>
<body>
<form action="ControlServlet" method="post">
    <h1>Delete Account</h1>
    <form action="ControllerServlet" method="post">
    <h2>Nhap account id can xoa:</h2>
    <label for="account_id">Account ID:</label>
    <input type="text" id="account_id" name="account_id" required maxlength="50"><br><br>
    <input type="hidden" name="action" value="deleteAccount">
        <button type="submit">Delete Account</button>
</form>
</form>
</body>
</html>
