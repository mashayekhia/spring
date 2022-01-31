<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Not Found Page</title>
</head>
<body>
<h1>Page Not Found!!!</h1>
<h1 style="color: red">Url :</h1> ${url}
<br/>
<h1 style="color: red">Exception Message : </h1> ${exception.getMessage()}
<br/>
<h1 style="color: red">Stack : </h1>
<br/>
<c:forEach items="${exception.getStackTrace()}" var="stackItem">
    ${stackItem}
</c:forEach>
</body>
</html>