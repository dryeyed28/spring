<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateForm.jsp</title>
<script>
function a() {
	n = parseInt(f.sgValue.value);
	f.sg[n-1].checked=true;
}
</script>
</head>
<body onload="a()">

<form action="/sns_server/update.do" method="post" name="f">
<p>
	회원 ID
	<input type="text" name="id" value="${member.id }" readonly/>
	
</p>
<p>
	회원 PWD
	<input type="text" name="pwd" value="${member.pwd }"/>
	
</p>
<p>
	이름
	<input type="text" name="name" value="${member.name }" readonly/>
</p>
<p>
	소속
	<input type="hidden" name="sgValue" value="${member.sg }" />
	<input type="radio" name="sg" value="1" />1 테크놀러지
	<input type="radio" name="sg" value="2" />2 테크놀러지
	<input type="radio" name="sg" value="3" />3 테크놀러지
	<input type="radio" name="sg" value="4" />4 테크놀러지
	
</p>
<p>
	전화번호
	<input type="text" name="tel" value="${member.tel }"/>
	
</p>
<p>
	주소
	<input type="text" name="address" value="${member.address }"/>
	
</p>
<p>
	<input type="submit" value="수정">
</p>
</form>
</body>
</html>