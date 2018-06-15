<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>
<body>

<form name="f" action="<%=request.getContextPath() %>/insert.do" method="post">
<table border="1">
<tr>
<td>작성자</td><td><input type="text" name="writer"></td>
</tr>
<tr>
<td>글 비밀번호</td><td><input type="password" name="pwd"></td>
</tr>
<tr>
<td>글 내용</td><td><textarea name="content" cols="40" rows="8"></textarea></td>
</tr>
<th>
<td colspan="2"><input type="submit" value="저장"></td>
</th>

</table>

</form>

</body>
</html>