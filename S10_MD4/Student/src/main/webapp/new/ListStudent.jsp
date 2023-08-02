<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/1/2023
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/new/add.jsp">Add Student</a>

<h1>Danh sách sinh viên</h1>
<table border="5" cellpadding="10">
    <tr>
        <th> ID</th>
        <th> Name</th>
        <th> Email</th>
     <th colspan="2">Action </th>
    </tr>
<c:forEach items="${students}" var="$">
    <tr>
        <td>${$.id}</td>
        <td>${$.name}</td>
        <td>${$.email}</td>
        <td><a onclick="return confirm('Are you sure???')" href="/Home?action=delete&id=${$.id}">Delete</a></td>
        <td><a href="/Home?action=edit&id=${$.id}">Edit</a></td>
    </tr>
</c:forEach>


</table>
</body>
</html>
