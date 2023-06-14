<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="emailConfiguration">
    <table>
        <tr>
            <td>Id:</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>Languages:</td>
            <td><form:select path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>Show <form:select path="pageSize" items="${pageSize}"/> email per page</td>
        </tr>
        <tr>
            <td>Spams Filter:</td>
            <td><form:checkbox path="spamsFilter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button>Update</form:button>
                <button>
                    <a href="/home" style="text-decoration: none">Cancel</a>
                </button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
