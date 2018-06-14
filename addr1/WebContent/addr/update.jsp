<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Member m = (Member)request.getAttribute("m");
%>
<form action="<%=request.getContextPath() %>/control?num=<%=m.getNum() %>" method="post">
<input type="hidden" name="type" value="edit">
이름 :<input type="text" name="name" value="<%=m.getName() %>"><br>
전화번호 :<input type="text" name="tel" value="<%=m.getTel() %>"><br>
주소:<input type="text" name="address" value="<%=m.getAddress() %>"<br>
우편번호 :<input type="text" name="Postal" value="<%=m.getPostal %>"><br>

<input type="submit" vlaue="수정">
</form>

</body>
</html>