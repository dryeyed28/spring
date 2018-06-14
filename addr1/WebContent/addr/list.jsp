<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("data");
%>
<br>
<table border=1><tr><th>num</th><th>name</th><th>tel</th><th>address</th><th>Postal</th></tr>
<%for(int i=0;i<list.size();i++){Member x=list.get(i); %>
<tr>
<td><%= x.getNum() %></td>
<td><%= x.getName() %></td>
<td><%= x.getTel() %></td>
<td><%= x.getAddress() %></td>
<td><%= x.getPostal() %></td>
</tr>
<%} %>
</table>

</body>
</html>