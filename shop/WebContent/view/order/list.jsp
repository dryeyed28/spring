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
<h3>전체 상품</h3>
<table border="1">
<tr><th>상품이미지</th><th>상품명</th></tr>
<c:forEach var="p" items="${products }">
<tr>
<td><img src="${p.img }" width="50" height="50"></td>
<td><a href="${pageContext.request.contextPath }/seller/detail.do?num=${p.num}">
${p.name }</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>