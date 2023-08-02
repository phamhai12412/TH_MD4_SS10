<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
<form method="post" action="/Home">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${param.id}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${param.name}">
    <br>
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="${param.email}">
    <br>
    <input type="submit" value="Update">
</form>
</body>
</html>
