<%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 25.11.16
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление студента</title>
</head>
<body>
<form method="post" action="addStudent">
    <p>Имя<br>
        <input type="text" name="name">
    </p>
    <p>Пол<Br>
        <input type="radio" name="gender" value="male"> М<Br>
        <input type="radio" name="gender" value="female"> Ж<Br>
    </p>
    <p>Группа<br>
        <input type="text" name="group_number">
    </p>
    <input type="submit">
</form>
</body>
</html>
