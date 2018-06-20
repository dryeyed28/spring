<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editForm.jsp</title>
</head>
<body>

<c:if test="${not empty m }"></c:if>
<form action="${pageContext.request.contextPath }/member/edit.do" method="post">
<table border="1">
<tr>
<td>id</td>
<td><input type="text" name="id" value="${m.id }" readonly>
<c:if test="${m.type==1 }">판매자</c:if>
<c:if test="${m.type==2 }">구매자</c:if>
</td>
</tr>
<tr>
<td>pwd</td>
<td><input type="text" name="pwd" value="${m.pwd }">
</td>
</tr>
<tr>
<td>name</td>
<td><input type="text" name="name" value="${m.name }" readonly>
</td>
</tr>
<tr>
<td>email</td>
<td><input type="text" name="email" value="${m.email }">
</td>
</tr>
<tr>
<td>address</td>
<td><input type="text" name="addr" value="${m.addr }">
</td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="수정"></td>
</tr>
</table>
</form>

</body>
</html>