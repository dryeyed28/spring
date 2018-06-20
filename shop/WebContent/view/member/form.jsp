<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>
<body>

<h3>회원가입</h3>
<form name="f" action="${pageContext.request.contextPath }/member/join.do" method="post">
<table border="1">
<tr>
<td>id</td><td><input type="text" name="id">
</td>
</tr>
<tr>
<td>pwd</td><td><input type="password" name="pwd"></td>
</tr>
<tr>
<td>name</td><td><input type="text" name="name"></td>
</tr>
<tr>
<td>email</td><td><input type="text" name="email"></td>
</tr>
<tr>
<td>address</td><td><input type="text" name="addr"></td>
</tr>
<tr>
<td>회원종류</td><td>
<input type="radio" name="type" value="1">판매자
<input type="radio" name="type" value="2">구매자
</td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="가입">
<input type="reset" value="취소">
</td>
</tr>
</table>
</form>

</body>
</html>