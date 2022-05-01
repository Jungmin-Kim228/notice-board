<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="csss/userAddForm.css" rel="stylesheet" type="text/css">
    <title>사용자 수정</title>
</head>
<body>
<h1>사용자 수정하기</h1>
<hr>
<c:set var="who" value="${pageContext.request.getParameter('who')}"></c:set>

<form method="post" action="${pageContext.request.contextPath}/userModify.do">
    <h2>수정하려는 사용자: ${who}</h2><br><br>
    <input hidden name="who" type="text" value="${who}"/>
    아이디 <input name="id" type="text" placeholder="미입력 시 기존 정보 유지"/><br><br>
    패스워드 <input name="pw" type="text" placeholder="미입력 시 기존 정보 유지"/><br><br>
    이름 <input name="name" type="text" placeholder="미입력 시 기존 정보 유지"/><br><br>
    프로필 <input name="profile" type="file" accept="image/*" onchange="setThumbnail(event);"/><br><br>
    미리보기 <br>
    <div id="imgContainer"></div>
    <br><input type="submit" value="수정"/>
</form>

<script>
    function setThumbnail(event) {
        var reader = new FileReader();

        reader.onload = function(event) {
            var img = document.createElement("img");
            img.setAttribute("src", event.target.result);
            document.querySelector("div#imgContainer").appendChild(img);
        };

        reader.readAsDataURL(event.target.files[0]);
    }
</script>
</body>
</html>
