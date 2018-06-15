<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editForm.jsp</title>
</head>
<body>

<h3>내 정보수정</h3>
<form action="<%=request.getContextPath() %>/edit.do">
<table border="1" style="border-collapse:collapse;">
<tr>
<td>아이디</td><td><input type="text" name="id"></td>
</tr>
<tr>
<td>비밀번호</td><td><input type="text" name="pwd"></td>
</tr>
<tr>
<td>날짜</td><td><input type="text" name="name"></td>
</tr>
<tr>
<td>내용</td><td><input type="text" name="content"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="수정">
</tr>
</table>
</form>

</body>
</html>