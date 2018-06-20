<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result.jsp</title>
</head>
<body>

${sessionScope.id }님 로그인 성공<br>
<a href="${pageContext.request.contextPath }/member/editForm.do">내정보수정</a><br>
<a href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a><br>
<a href="${pageContext.request.contextPath }/member/out.do">탈퇴</a><br>


</body>
</html>