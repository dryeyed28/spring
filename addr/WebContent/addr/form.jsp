<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/insert.do">
name : <input type="text" name="name"><br>
tel : <input type="text" name="tel"><br>
address : <input type="text" name="address"><br>
<input type="submit" value="저장"><br>
</form>
</body>
</html>