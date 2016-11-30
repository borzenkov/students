<%--
  Created by IntelliJ IDEA.
  User: imac
  Date: 29.11.16
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="editLecture">
    <p>Тема<br>
        <input type="text" name="topic" value="${lecture.getTopic()}">
    </p>
    <p>Дата<br>
        <input type="text" name="date" value="${lecture.getDate()}">
    </p>
    <input type="submit">
</form>
<a href="deleteLecture?id=${lecture.getId()}">Удалить лекцию</a>
</body>
</html>
