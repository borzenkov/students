<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 24.11.16
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Лекции</title>
</head>
<body>
<a href="/index.jsp">На главную</a>
<a href="/addLecture.jsp">Добавить лекцию</a>
<br>
<c:forEach items="${lectures}" var="item">
    <a href="/editLecture?id=${item.getId()}">${item}<br></a>
</c:forEach>
</body>
</html>
