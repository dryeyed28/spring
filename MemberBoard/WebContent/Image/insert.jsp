<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insert.jsp</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/Image/insert.do" method="post" enctype="multipart/form-data">
게시자 : <input type="text" name="id"><br>
제목 : <input type="text" name="title" /><br>
사진 : <input type="file" name="file" /><br>
<input type="submit" />
</form>

</body>
</html>