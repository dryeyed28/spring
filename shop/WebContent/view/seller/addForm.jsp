<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addForm.jsp</title>
</head>
<body>

<h3>상품등록</h3>
<form action="${pageContext.request.contextPath }/seller/add.do" method="post" enctype="multipart/form-data">
상품명 : <input type="text" name="name"><br>
수량 : <input type="text" name="quantity"><br>
가격 : <input tyep="text" name="price"><br>
상품이미지등록 : <input type="file" name="file"><br>
상세설명 : <textarea rows="10" cols="30" name="content"></textarea>
<br>
<input type="submit" value="등록">
</form>

</body>
</html>