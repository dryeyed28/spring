<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/edit.do">
name : <input type="text" name="name" value="${person.name }"><br>
tel : <input type="text" name="tel" value="${person.tel }"><br>
address : <input type="text" name="address" value="${person.address }"><br>
<input type="submit" value="수정완료"><br>
</form>
</body>
</html>