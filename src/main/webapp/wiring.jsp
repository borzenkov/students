<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 24.11.16
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Привязка</title>
</head>
<body>
<a href="/index.jsp">На главную</a><br>


<form method="post" action="wiring">
    <select name="student">
        <c:forEach items="${students}" var="item">
            <option value="${item.getId()}">${item.getName()}</option>
        </c:forEach>
    </select>

    <select name="lecture">
        <c:forEach items="${lectures}" var="item">
            <option value="${item.getId()}">${item.getTopic()}</option>
        </c:forEach>
    </select>

    <input type="submit">
</form>

</body>
</html>
