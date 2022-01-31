<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ir.man.spring.model.ProductCategory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<h1>گام دوم</h1>
<form method="post" action="/products/new?step=3">
    <input type="hidden" id="id" name="id" value="${productCategory.id }">
    <br/>
    <label for="name">نام</label>
    <input type="text" id="name" name="name" value="${productCategory.name}">
    <br/>
    <input type="submit" value="Next">
</form>
</body>
</html>