<%--
  Created by IntelliJ IDEA.
  User: aruzhan one love
  Date: 06.05.2024
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<h1>Admin Page - Users List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Role</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
