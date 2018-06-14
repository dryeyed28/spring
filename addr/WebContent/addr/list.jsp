<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/addr/form.jsp">주소등록</a>
<table border="1">
<tr><tr>name</tr><th>tel</th><th>address</th><th>edit</th></tr>
<c:forEach var="person" items="${data}">
<tr><td>${person.name}</td><td>${person.tel }</td>
<td>${person.address }</td>
<td><a href="<%=request.getContextPath() %>
/editForm.do?name=${person.name }">수정</a>,
<a href="<%=request.getContextPath() %>
/del.do?name=${person.name}">삭제</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>