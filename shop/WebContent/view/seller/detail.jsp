<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail.jsp</title>
<script type="text/javascript">
function a() {
	var flag = confirm("정말 삭제하시겠습니까?")
	if(flag) {
		document.f.action = "${pageContext.request.contextPath}/seller/del.do";
		document.f.submit();
	} else {
		alert("삭제가 취소되었습니다.");
	}
}
</script>
</head>
<body>

<form name="f" action="${pageContext.request.contextPath }/seller/edit.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr>
<th>상품명</th><td><input type="text" value="${p.name }" name="name"></td>
</tr>
<tr>
<th>가격</th><td><input type="text" value="${p.price }" name="price"></td>
</tr>
<tr>
<th>수량</th><td><input type="text" value="${p.quantity }" name="quantity"></td>
</tr>
<tr>
<th>상품 이미지</th><td><img src="${p.img }" width="300" height="300"/>
</td>
</tr>
<tr>
<th>상품이미지 변경 </th><td><input type="file" name="file"></td>
</tr>
<th>상품상세설명</th><td><input type="text" value="${p.content }" name="content"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="수정">
<input type="button" value="삭제" onclick="a()"></td>
</tr>
</table>
</form>

</body>
</html>