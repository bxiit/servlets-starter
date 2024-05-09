<%--
  Created by IntelliJ IDEA.
  User: aruzhan one love
  Date: 05.05.2024
  Time: 02:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>
<h2>Registration Form</h2>
<form action="registration" method="post">
    <label for="username">Name:</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    <br>
    <c:if test='<%=request.getParameter("error") != null%>'>
        <span style="color: red">
            <%=request.getParameter("error")%>
        </span>
        <br>
    </c:if>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
