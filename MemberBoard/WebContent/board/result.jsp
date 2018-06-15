<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result.jsp</title>
</head>
<body>
 
<a href="<%=request.getContextPath() %>/form.do">글쓰기</a><br>
<table border="1">
<tr>
<td>num</td><td>pwd</td><td>writer</td><td>w_date</td><td>content</td>
</tr>
<th>
<td><${b.num }/td><td>${b.pwd }</td><td>${b.writer }</td><td>${b.board_date }</td><td>${b.content }</td><td><a href="<%=request.getContextPath() %>/update.do">수정</a>,<a href="<%=request.getContextPath() %>/delete.do">삭제</a></td>
</th>
</table>

</body>
</html>