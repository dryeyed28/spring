<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${id }님 로그인 성공<br>
<a href="<%=request.getContextPath() %>/editMember.do?type=search">내정보수정</a><br>
<a href="<%=request.getContextPath() %>/logout.do?type=logout">로그아웃</a><br>
<a href="<%=request.getContextPath() %>/del.do?type=out">탈퇴</a><br>
<a href="<%=request.getContextPath() %>/BoardController?type=boardList">게시판</a><br>

</body>
</html>