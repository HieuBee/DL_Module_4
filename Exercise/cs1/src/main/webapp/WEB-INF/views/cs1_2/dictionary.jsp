<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/8/2023
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<cfprocessingdirective pageencoding="utf-8" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/US" method="post">
    English: <input type="text" name="US">
    <input type="submit" name="Submit">
    <br>
</form>
VietNam: <span style="font-weight: bold">${VN}</span>
</body>
</html>
