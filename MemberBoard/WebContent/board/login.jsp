<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
</head>
<body>

<h3>로그인</h3>
<from name="f" action="<%=request.getContextPath() %>/login.do" method="post">
<table border="1">
<tr>
<td>id</td><td><input type="text" name="id"></td>
</tr>
<tr>
<td>pwd</td><td><input type="password" name="pwd"></td>
</tr>
<td colspan="2"><input type="submit" value="로그인">
</table>

</body>
</html>