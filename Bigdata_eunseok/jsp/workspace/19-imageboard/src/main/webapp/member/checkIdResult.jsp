<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkIdClose(){
		opener.frm.id.value = ${id };
		opener.frm.pwd.focus();
		opener.frm.check.value = "true";
		window.close();
	}
</script>
</head>
<body>
	<form action="../member/checkId.jsp" method="post" name="checkId_frm">
		<c:choose>
			<c:when test="${chk }">
				${id }는 사용중입니다.<br><br>
				아이디 <input type="text" name="id">
				<input type="submit" value="중복 확인">
			</c:when>
			<c:otherwise>
				${id }는 사용가능합니다.<br><br>
				<input type="button" value="사용" onclick="checkIdClose()">
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>