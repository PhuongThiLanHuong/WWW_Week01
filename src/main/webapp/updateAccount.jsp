<%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 11/30/2023
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Account</title>
</head>
<style>
    form {
        border: 3px solid #f1f1f1;
    }

    input[type=text], input[type=password], input[type=email], input[type=number] {
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
<div class="container">
<form action="ControllerServlet" method="post">

    <h1>Nhap account id can chinh sua:</h1>
    <label for="account_id">Account ID:</label>
    <input type="text" id="account_id" name="account_id" required maxlength="50"><br><br>
    <h2>Nhap cac thong tin can chinh sua:</h2>
    <label for="full_name">Full Name:</label>
    <input type="text" id="full_name" name="full_name" required maxlength="50"><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required maxlength="50"><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" maxlength="50"><br><br>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" maxlength="50"><br><br>

    <label for="status">Status:</label>
    <input type="number" id="status" name="status" required min="0" max="1"><br><br>

    <input type="hidden" name="action" value="updateAccount">
    <button type="submit">Update Account</button>

</form>
</body>
</html>
