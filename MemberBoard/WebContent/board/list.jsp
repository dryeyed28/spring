<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


<a href="<%=request.getContextPath()%>/board/form.jsp">글쓰기</a>
<table border="1">
<tr><th>num</th><th>pwd</th><th>writer</th><th>w_date</th><th>content</th>   </tr>


<c:forEach var="b" items="${articles }">
<tr><td>${b.num }</td><td>${b.pwd }</td><td>${b.writer }</td>
<td>${b.w_date }</td><td>${b.content }</td>

<td><a href="<%=request.getContextPath()%>
/editForm.do?num=${b.num }">수정</a>, 

<a href="<%=request.getContextPath()%>
/boarddel.do?num=${b.num }">삭제</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>


