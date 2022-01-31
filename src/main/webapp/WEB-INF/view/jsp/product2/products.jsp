<%@ page import="java.util.List" %>
<%@ page import="ir.man.spring.model.Product2" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Home</title>
</head>
<body>
<h1>Welcome to your Products</h1>
<table border="1px solid green">
    <thead>
    <tr>
        <th>کد</th>
        <th>نام</th>
        <th>وضعیت</th>
        <th>عملیات</th>
        <th>آخرین عملیات</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${Products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.status ? "فعال" : "غیرفعال"}</td>
            <td><a href="${pageContext.request.contextPath}/products/detail?pid=${product.id}">جزئیات</a></td>
            <td><a href="${pageContext.request.contextPath}/products/pmvariables/${product.id};q1=10;q2=20">PathVariable_MatrixVariable</a>
            </td>
            <td>
                <c:if test="${product.id eq lastActionOnProduct.id and not empty message}">
                    <h6>${message}</h6>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/products/step1">محصول جدید</a>
</body>
</html>