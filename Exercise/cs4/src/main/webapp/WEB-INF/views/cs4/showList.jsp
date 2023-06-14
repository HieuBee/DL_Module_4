<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
            <td>${item.languages}</td>
            <td>${item.pageSize}</td>
            <td>${item.spamsFilter}</td>
            <td>${item.signature}</td>
            <td>
                <button>
                    <a href="/home/update?id=${item.id}">Update</a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
