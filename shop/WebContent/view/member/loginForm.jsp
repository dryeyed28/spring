<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginForm.jsp</title>
</head>
<body>

<h3>로그인</h3>
<form name="f" action="${pageContext.request.contextPath }/member/login.do" method="post">
<table border="1">
<tr>
<td>id</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td>pwd</td>
<td><input type="password" name="pwd"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="로그인">
<a href="${pageContext.request.contextPath }/member/form.do">회원가입</a>"
</td>
</tr>
</table>
</form>

</body>
</html>