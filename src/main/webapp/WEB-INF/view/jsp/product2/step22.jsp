<%@ page import="java.util.List" %>
<%@ page import="ir.man.spring.model.Product2" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<h1>گام دوم</h1>
${sessionScope.product2}
<form method="post" action="/products/update">
    <input type="hidden" id="id" name="id" value="${sessionScope.product2.id}">
    <label for="name">نام</label>
    <input type="text" id="name" name="name" value="${sessionScope.product2.name}">
    <br />
    <label for="status">وضعیت</label>
    <input type="checkbox" id="status" name="status" checked="${sessionScope.product2.status}">
    <br />
    <input type="submit" value="ویرایش">
</form>
</body>
</html>