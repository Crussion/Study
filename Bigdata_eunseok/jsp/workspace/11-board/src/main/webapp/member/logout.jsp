<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("memName");
	session.removeAttribute("memId");
	
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		alert("๋ก๊ทธ์์");
		location.href="../main/index.jsp";
	}
</script>
</head>
<body>

</body>
</html>