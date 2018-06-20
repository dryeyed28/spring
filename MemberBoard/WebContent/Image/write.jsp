<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core %>
<%-- []는 배열을 의미 하고 {}는 하나의 객체를 의미 한다.
 forEach에서 아이템에서 데이터 값을 a에 담고 varStatus는 반복의 상태를 지정할 변수를 stat로 하고
 if test는 조건이니까 {img_num:${a.img_num }, writer:'${a.writer }', content:'${a.content }'}이
  하나의 객체라고 했으니까 하나 출력을 하고 콤마를 붙여서 출력을 한다.--%>


[
<c:forEach var="a" items="$(data)" varStatus="stat">
<c:if test="${stat.index != 0 }">,</c:if>
{img_num:${a.img_num }, writer:'${a.wirter }', content:'${a.content }'}
</c:forEach>
]

