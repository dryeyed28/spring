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
<form action="<%=request.getContextPath() %>/login.do" method="post">
<table border="1" cellspacing="0">
<tr>
<td>아이디</td><td><input type="text" name="id"></td>
</tr>
<tr>
<td>비밀번호</td><td><input type="password" name="pwd"></td>
</tr>
<tr>
<td colspan="2"><input type="reset" value="다시입력"><input type="submit" value="전송">
<a href="<%=request.getContextPath() %>/form.do">회원가입</a>
</td>
</tr>
</table>
</form>
<a href="<%=request.getContextPath() %>/list.do">게시글보기</a>"

</body>
</html>