<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginForm.jsp</title>
</head>
<body>

<h2>로그인</h2>
<form action="/sns_server/login.do" method="post">
id : <input type="text" name="id"><br>
pwd : <input type="text" name="pwd"><br>
<input type="submit" value="로그인"><br>
</form>
<a href="/sns_server/regist.do">회원가입</a>

</body>
</html>