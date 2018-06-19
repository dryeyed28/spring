<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>joinForm.jsp</title>
</head>
<body>

<spring:hasBindErrors name="member"/><!-- 유효성 지정 -->
<form:errors path="member"/>
<form action="/sns_server/insert.do" method="post">
<p>
	회원 ID
	<input type="text" name="id" value="${member.id }"/>
	<form:errors path="member.id" />
</p>
<p>
	회원 PWD
	<input type="text" name="pwd" value="${member.pwd }"/>
	<form:errors path="member.pwd" />
</p>
<p>
	이름
	<input type="text" name="name" value="${member.name }"/>
	<form:errors path="member.name" />
</p>
<p>
	소속
	<input type="radio" name="sg" value="1"/>1 테크놀러지
	<input type="radio" name="sg" value="2"/>2 테크놀러지
	<input type="radio" name="sg" value="3"/>3 테크놀러지
	<input type="radio" name="sg" value="4"/>4 테크놀러지
	<form:errors path="member.sg" />
</p>
<p>
	전화번호
	<input type="text" name="tel" value="${member.tel }"/>
	<form:errors path="member.tel" />
</p>
<p>
	주소
	<input type="text" name="address" value="${member.address }"/>
</p>
<p>
	<input type="submit" value="회원 등록">
</p>
</form>
</body>
</html>