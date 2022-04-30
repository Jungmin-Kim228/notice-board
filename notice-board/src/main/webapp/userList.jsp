<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>관리자 모드</title>
    <link href="csss/userList.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>사용자 리스트</h1>
<button class="headButton" onclick="location.href='/logout.do'">로그아웃</button>
<button class="headButton" onclick="location.href='/userAddForm.jsp'">사용자 추가</button>
<hr><br>
<c:set var="users" value="${applicationScope.users}"></c:set>

<table>
    <tr>
        <th>이름</th>
        <th>아이디</th>
        <th>패스워드</th>
        <th>프로필</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <c:if test="${!user.value.getId().equals('admin')}" var="testResult">
            <tr>
                <td>${user.value.getName()}</td>
                <td>${user.value.getId()}</td>
                <td>${user.value.getPw()}</td>
                <td>${user.value.getProfileFileName()}</td>
                <td>
                    <form class="form" method="post" action="${pageContext.request.contextPath}/userModify.do">
                        <input type="hidden" name="who" value="${user.value.getId()}"/>
                        <input type="submit" value="수정"/>
                    </form>
                    <form class="form" method="post" action="${pageContext.request.contextPath}/userDelete.do">
                        <input type="hidden" name="who" value="${user.value.getId()}"/>
                        <input type="submit" value="삭제"/>
                    </form>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>

