<%@ page import="java.util.List" %>
<%@ page import="ir.man.spring.model.Product2" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<h1>گام اول</h1>
<form method="post" action="/products/step22">
    <input type="text" id="id" name="id" value="${product.id}">
    <label for="name">نام</label>
    <input type="text" id="name" name="name" value="${product.name}">
    <br />
    <label for="status">وضعیت</label>
    <input type="checkbox" id="status" name="status" checked="${product.status}">
    <br />
    <input type="submit" value="ثبت محصول جدید">
</form>
</body>
</html>