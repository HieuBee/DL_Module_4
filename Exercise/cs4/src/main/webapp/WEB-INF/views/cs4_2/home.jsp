<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/6/2023
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button>
    <a href="/home/add">Add</a>
</button>
${error}
<table>
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Languages</th>
        <th>Page size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${list}" varStatus="status" >
        <tr>
            <td>${status.count}</td>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.listSong}</td>
            <td>${item.file}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
