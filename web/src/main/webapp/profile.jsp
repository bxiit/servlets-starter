<%@ page import="example.com.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: aruzhan one love
  Date: 05.05.2024
  Time: 02:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile page</title>
</head>
<body>
    <h1>Name <%= ((User) request.getSession().getAttribute("user")).getUsername()%> </h1>
    <h1>Email <%= ((User) request.getSession().getAttribute("user")).getEmail()%> </h1>
    <h1>Role <%= ((User) request.getSession().getAttribute("user")).getRole()%> </h1>

    <form action='<%="/logout"%>' method="post">
        <input type="submit" value="logout">
    </form>
</body>
</html>
