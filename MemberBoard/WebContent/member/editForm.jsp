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
id : <input type="text" name="id" value="${m.id }"><br>
pwd : <input type="text" name="pwd" value="${m.pwd }"><br>
name : <input type="text" name="id" value="${m.name }"><br>
email : <input type="text" name="id" value="${m.email }"><br>

<input type="submit" value="수정완료"><br>
</form>

</body>
</html>