<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/login.do">
        아이디: <input type="text" name="id" required/><br><br>
        패스워드: <input type="password" name="pw" required/><br><br>
        <input type="submit" value="로그인"/>
    </form>
</body>
</html>
