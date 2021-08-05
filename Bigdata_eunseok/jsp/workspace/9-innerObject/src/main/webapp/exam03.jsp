<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>respense : 리다이렉트</h3>
	<script type="text/javascript">
		alert("현재 페이지는 <b>exam03.jsp</b>페이지 입니다.")
	</script>
	
	<%
		response.sendRedirect("exam03Pro.jsp");
	%>
</body>
</html>