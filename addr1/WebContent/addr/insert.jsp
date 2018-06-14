<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	function checkInsert(r) {
		
		if(r.name.value=="") {
			alert("이름을 입력하세요~~!!!");
			r.name.focus();
			return;
		} else if(r.tel.value=="") {
			alert("전화번호를 입력하세요~~!!!");
			r.tel.focus();
			return;
		} else if(r.address.value=="") {
			alert("주소를 입력하세요~~!!!");
			r.address.focus();
			return;
		} else if(r.Postal.value=="") {
			alert("우편번호를 입력하세요~~!!!");
			r.Postal.focus();
			return;
		}
		r.submit();
	}
</script>
<body>
 <form name="x" action="<%=request.getContextPath() %>/control?type=insert" method="post">
<table>
<tr>
 <td>이  름 : <input type="text" name="name"><br><br>
 </tr>
<tr>
 <td>전화번호 : <input type="text" name="tel"><br><br></td>
 </tr>

<tr>
 <td>주 소 : <input type="text" name="address"></td>
 </tr>

<tr>
 <td>우편번호 <input type="text" name="Postal"></td>
 </tr>

</table>

<input type="button" onClick="checkInsert(this.form)" value="주소입력">
</form>
</table> 
 </form>

</body>
</html>