<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
</head>
<body>

	<c:if test="${!empty sessionScope.id }">
		<a href="<%=request.getContextPath() %>/editForm.do">내 정보수정</a>
		<a href="<%=request.getContextPath() %>/logout.do">로그아웃</a>
		<a href="<%=request.getContextPath() %>/del.do">탈퇴</a>
		<a href="<%=request.getContextPath() %>/boardForm.do">글쓰기</a>
	</c:if>	

</body>
</html>