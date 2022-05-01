<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="csss/userAddForm.css" rel="stylesheet" type="text/css">
    <title>게시글 수정</title>
</head>
<body>
<h1>게시글 수정하기</h1>
<hr>
<c:set var="which" value="${pageContext.request.getParameter('which')}"></c:set>
<c:set var="post" value="${applicationScope.posts.getPost(which)}"></c:set>
<c:set var="users" value="${applicationScope.users}"></c:set>

<form method="post" action="${pageContext.request.contextPath}/boardModify.do">
    <h2>수정하려는 게시글 번호: ${which}</h2><br><br>
    <input hidden name="which" type="text" value="${which}"/>
    제목: <input name="title" type="text" placeholder="${post.getTitle()}"/><br><br>
    내용: <input name="content" type="text" placeholder="${post.getContent()}"/><br><br>
    작성자 이름: ${users.getUser(post.getWriterUserId()).getName()}<br><br>
    <input hidden name="writer" type="text" value="${post.getWriterUserId()}"/>
    작성시간 <input name="writeTime" type="datetime-local"/><br><br>
    <br><input type="submit" value="수정"/>
</form>

</body>
</html>
