<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 홈</title>
    <link href="csss/boardList.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>게시판</h1>
<button class="headButton" onclick="location.href='/logout.do'">로그아웃</button>
<button class="headButton" onclick="location.href='/boardAddForm.jsp'">게시물 추가</button>
<hr><br>
<c:set var="posts" value="${applicationScope.posts.getPosts()}"></c:set>
<c:set var="users" value="${applicationScope.users}"></c:set>

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
            <td>${users.getUser(post.value.getWriterUserId()).getName()}</td>
            <td><javatime:format value="${post.value.getWriteTime()}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <td>${post.value.getViewCount()}</td>
            <td>
                <form class="form" method="post" action="${pageContext.request.contextPath}/boardModifyAccessCheck.do">
                    <input type="hidden" name="which" value="${post.value.getId()}"/>
                    <input type="submit" value="수정"/>
                </form>
                <form class="form" method="post" action="${pageContext.request.contextPath}/boardDelete.do">
                    <input type="hidden" name="which" value="${post.value.getId()}"/>
                    <input type="submit" value="삭제"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>