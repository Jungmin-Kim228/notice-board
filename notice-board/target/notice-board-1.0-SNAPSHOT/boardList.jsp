<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<h1>게시판리스트</h1>
<c:set var="users" value="${users}"></c:set>
<c:forEach var="user" items="${users}">
    ${user.key} = ${user.value.getName()} + ${user.value.getPw()}
</c:forEach>
<c:out value="${session.id}"></c:out>
<a href="${pageContext.request.contextPath}/logout.do">logout</a>
</body>
</html>
