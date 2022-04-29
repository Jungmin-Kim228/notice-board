<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<h1>게시판리스트</h1>
<c:set var="users" value="${users}"></c:set>
<c:forEach var="i" items="${users}">
    ${i.key} = ${i.value}
</c:forEach>
<c:out value="${session.id}"></c:out>
</body>
</html>
