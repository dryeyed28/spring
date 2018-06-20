<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list.jsp</title>
</head>
<body>

<a href="${pageContext.request.contextPath }/view/member/result.jsp">
내정보
</a><br>
<h3>내가 등록한 상품</h3>
<a href="${pageContext.request.contextPath }/seller/addForm.do">
새 상품 등록
</a>
<table border="1">
<tr><th>상품번호</th><th>상품명</th></tr>
<c:forEach var="p" items="${products }">
<tr>
<td>${p.num }</td><td><a href="${pageContext.request.contextPath }/seller/detail.do?num=${p.num }">${p.name }</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>