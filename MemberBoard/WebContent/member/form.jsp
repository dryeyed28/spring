<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>회원가입</h3>
<form name="f" action="<%=request.getContextPath() %>/insert.do" method="post">
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
<td colspan="2"><input type="submit" value="가입">
<input type="reset" value="취소">
</td>
</tr>
</table>
</form>

</body>
</html>