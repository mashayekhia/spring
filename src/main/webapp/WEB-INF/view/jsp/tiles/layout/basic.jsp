<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <tiles:getAsString name="title"/>
    </title>
</head>
<body>
<div>
    <tiles:insertAttribute name="header"/>
</div>
<div id="container ">
    <tiles:insertAttribute name="body"/>
</div>
<div>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>