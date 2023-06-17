<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/6/2023
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="musicFile">
    <table>
        <tr>
            <td>Id:</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>List song:</td>
            <td>Show <form:select path="listSong" items="${categories}"/></td>
        </tr>
        <tr>
            <td>File:</td>
            <td><form:input type="file" path="file"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button>Add</form:button>
                <button>
                    <a href="/home" style="text-decoration: none">Cancel</a>
                </button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
