<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Ứng dụng Product Discount Calculator\n" %>
</h1>
<br/>
<form action="display-discount" method="post">
    <label for="productDescription">Product Description:</label>
    <input type="text" id="productDescription" name="productDescription" required><br>

    <label for="listPrice">List Price:</label>
    <input type="number" id="listPrice" name="listPrice" min="0" required><br>

    <label for="discountPercent">Discount Percent:</label>
    <input type="number" id="discountPercent" name="discountPercent" min="0" max="100" required><br>

    <input type="submit" value="Calculate Discount">
</form>
</body>
</html>