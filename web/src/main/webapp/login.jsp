<%--
  Created by IntelliJ IDEA.
  User: aruzhan one love
  Date: 05.05.2024
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>

<form action="/login" method="post">
    <label for="email">
        <input type="text" name="email" id="email"
               value='<%=request.getParameter("email") == null ? "" : request.getParameter("email")%>' required>
    </label><br>

    <label for="password">
        <input type="password" name="password" id="password" required>
    </label><br>

    <button type="submit">Login</button>
    <a href="/registration">
        <button type="button">Register</button>
    </a><br>

    <c:if test='<%=request.getParameter("error") != null%>'>
    <span style="color: red">
        Email <%=request.getParameter("email")%> is incorrect or not registered!
    </span>
    </c:if>
</form>

</body>
</html>
