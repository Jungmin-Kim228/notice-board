<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="csss/userAddForm.css" rel="stylesheet" type="text/css">
    <title>사용자 추가</title>
</head>
<body>
  <h1>사용자 추가하기</h1>
<hr>
  <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/userAdd.do">
      아이디 <input name="id" type="text" required/><br><br>
      패스워드 <input name="pw" type="text" required/><br><br>
      이름 <input name="name" type="text" required/><br><br>
      프로필 <input name="profile" type="file" accept="image/*" required onchange="setThumbnail(event);"/><br><br>
      미리보기 <br>
      <div id="imgContainer"></div>
      <br><input type="submit" value="추가"/>
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
