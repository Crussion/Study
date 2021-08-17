<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function (){
		if(${memName != null}){
			alert("로그인 성공");
			location.href = "../main/index.jsp";
		}else{
			alert("로그인 실패");
			location.href = "../main/index.jsp?req=loginForm";
		}
	}
</script>
</head>
<body>
</body>
</html>