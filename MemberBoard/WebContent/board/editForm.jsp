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
<form action="<%=request.getContextPath() %>/boardedit.do?num=${m.num}" method="post">
<table border="1" cellspacing="0">
<tr>
<td>아이디</td><td><input type="text" name="id" readonly value="${m.writer }"></td>
</tr>
<tr>
<td>비밀번호</td><td><input type="text" name="pwd" value="${m.pwd }"></td>
</tr>
<tr>
<td>날짜</td><td><input type="text" name="name" value="${m.w_date }"></td>
</tr>
<tr>
<td>내용</td><td><input type="text" name="content" value="${m.content }"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="수정">
</tr>
</table>
</form>

</body>
</html>