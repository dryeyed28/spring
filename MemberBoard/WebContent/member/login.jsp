<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>로그인</h3>
<form name="f" action="<%=request.getContextPath() %>/login.do" method="post">
<table border="1">
<tr>
<td>id</td>
<td><input type="text" name="id"></td>
</tr>
<td>pwd</td>
<td><input type="password" name="pwd"></td>
</tr>
<td colspan="2"><input type="submit" value="로그인">
<a href="<%=request.getContextPath() %>/member/form.jsp">회원가입</a>
</td>
</tr>
</table>
</form>

</body>
</html>