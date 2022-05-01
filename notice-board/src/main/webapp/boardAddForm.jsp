<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="csss/userAddForm.css" rel="stylesheet" type="text/css">
    <title>게시물 추가</title>
</head>
<body>
<h1>게시물 추가하기</h1>
<hr>

<c:set var="sessionId" value="${pageContext.request.getSession(false).getAttribute('id')}"></c:set>
<form method="post" action="${pageContext.request.contextPath}/boardAdd.do">
    <input hidden name="id" value="${applicationScope.boardCount}"/>
    제목 <input name="title" type="text" required/><br><br>
    내용 <input name="content" type="text" required/><br><br>
    작성자ID: ${sessionId}<br><br>
    <input hidden name="writer" type="text" value="${sessionId}"/>
    작성시간 <input name="writeTime" type="datetime-local" /><br><br>
    <br><input type="submit" value="추가"/>
</form>

</body>
</html>
