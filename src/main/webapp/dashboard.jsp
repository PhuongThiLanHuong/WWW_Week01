<%@ page import="vn.edu.iuh.fit.week01.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 9/28/2023
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
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
</head>
<body>
<h1>Welcome to dashboard</h1>
<h2>Ban da dang nhap thanh cong voi vai tro admin</h2>

<%
    Account account = (Account) request.getAttribute("account");

    if(account!= null){
%>

<table>
    <tbody>
    <tr>
        <h2>Welcome Admin <%= account.getFull_name()%></h2>
        <h4>Account Id: <%= account.getAccount_id()%></h4>

        <h4>Account email: <%= account.getEmail()%></h4>

        <h4>Account phone: <%=account.getPhone()%></h4>

        <h4>Account status: <%=account.getStatus()==1?"hoạt động": "không hoạt động"%></h4>


    </tr>
    </tbody>


</table>
<%
    }
%>
    <div class="link">
        <a href="createAccount.jsp">Create Account</a>
        <a href="deleteAccount.jsp">Delete Account</a>
    </div>
<input type="hidden" name="action" value="Logout">
<button type="submit">Logout</button>
</body>
</html>
