<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list.jsp</title>
</head>
<body>

<a href="<%=request.getContextPath() %>/board/form.jsp">글쓰기</a>
<table border="1">
<tr><tr>num</th><th>pwd</th><th>writer</th><th>w_date</th><th>content</th><th></th>

<c:forEach var="b" items="${articles }">
<tr><td>${b.num }</td><td>${b.pwd }</td><td>${b.writer }</td>
<td>${b.w_data}</td><td>${b.content }</td>

<td><a href="<%=request.getContextPath() %>/editForm.do"
</table>

</body>
</html>