<%@ page import="entities.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 28.11.16
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="student" scope="session" value="${2000*2}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="editStudent">
    <p>Имя<br>
        <input type="text" name="name" value="${student.getName()}">
    </p>
    <p>Пол<Br>
        <input type="radio" name="gender" value="male"
            <% String gender = ((Student)request.getAttribute("student")).getGender();
            if (gender.equals("male")) {%>
               checked="checked"
            <%}%>
        > М<Br>
        <input type="radio" name="gender" value="female"
            <% if (gender.equals("female")) {%>
               checked="checked"
            <%}%>
        > Ж<Br>
    </p>
    <p>Группа<br>
        <input type="text" name="group_number" value="${student.getGroupNumber()}">
    </p>
    <input type="submit">
</form>
</body>
</html>
