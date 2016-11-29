<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 24.11.16
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студенты</title>
</head>
<body>
<a href="/index.jsp">На главную</a>
<a href="/addStudent.jsp">Добавить студента</a>
<br>
<c:forEach items="${students}" var="item">
    <a href="/editStudent?id=${item.getId()}">${item}<br></a>
</c:forEach>
</body>
</html>
