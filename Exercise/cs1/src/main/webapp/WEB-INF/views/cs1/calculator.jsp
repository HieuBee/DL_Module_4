<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/8/2023
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/usd" method="post">
    Input USD:
    <input type="number" name="usd">
    <input type="submit" value="Submit">
    <br>
    => VND: <h3>${vnd}</h3>
</form>
</body>
</html>
