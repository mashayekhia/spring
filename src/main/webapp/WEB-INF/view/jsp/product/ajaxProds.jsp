<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
    <script>
        var _products = null;
        $(document).ready(function () {
            $("button").click(function () {
                $("span").html("<h1>ok</h1>");
                $.ajax({
                    // type: "get",
                    // Accept: "application/json",
                    // url: "http://localhost:5000/product-api",
                    // success: function (result, status, xhr) {
                    //     $("span").html(JSON.stringify(result));
                    // }

                    type: "post",
                    contentType: "application/json",
                    url: "http://localhost:5000/product-api/ajaxProds",
                    data: JSON.stringify({"ProdId":1,"ProdName":"Computer"}), // when send product(s) with POST
                    success: function (result, status, xhr) {
                        $("span").html(JSON.stringify(result));
                    }
                })
            });
        });
    </script>
    <title>Product Home</title>
</head>
<body>
<h1>Welcome to your Products</h1>
<span></span>
<button>Click to Load Products with Ajax</button>
<c:if test="${productGroupCount gt 1}">
    <c:forEach begin="1" end="${productGroupCount}" var="pageNum">
        <a href="${pageContext.request.contextPath}/products/${pageNum}">${pageNum} </a>
    </c:forEach>
</c:if>
<br/>
<a href="${pageContext.request.contextPath}/products/new?step=1">محصول جدید</a>
</body>
</html>