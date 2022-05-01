<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 홈</title>
    <link href="csss/userList.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>게시판</h1>
<button class="headButton" onclick="location.href='/logout.do'">로그아웃</button>
<button class="headButton" onclick="location.href='/boardAdd.jsp'">게시물 추가</button>
<hr><br>
<c:set var="posts" value="${applicationScope.posts.getPosts()}"></c:set>

<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>작성시간</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td>${post.value.getId()}</td>
            <td>${post.value.getTitle()}</td>
            <td>${post.value.getContent()}</td>
            <td>${post.value.getWriterUserId()}</td>
            <td>${post.value.getWriteTime()}</td>
            <td>${post.value.getViewCount()}</td>
            <td>
                <form class="form" method="post" action="${pageContext.request.contextPath}/userModify.jsp">
                    <input type="hidden" name="which" value="${post.value.getId()}"/>
                    <input type="submit" value="수정"/>
                </form>
                <form class="form" method="post" action="${pageContext.request.contextPath}/userDelete.do">
                    <input type="hidden" name="which" value="${post.value.getId()}"/>
                    <input type="submit" value="삭제"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>