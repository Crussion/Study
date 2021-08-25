<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body { margin: 0; }
#header { border: 1px solid black; }
#nav { float:left; background: orange; width: 200px; height: 500px;}
#footer { border: 1px solid black; clear: both;}
</style>
</head>
<body>
	<div id="header" align="center">
		<h1>게시판</h1>
	</div>
	<div id="nav">
		<h3><a href="index.jsp">*** 메인 화면 ***</a></h3>
		<c:if test="${memId == null}">
			<a href="index.jsp?req=loginForm">로그인</a><br>
			<a href="index.jsp?req=writeForm">회원가입</a><br>
		</c:if>
		<c:if test="${memId != null }">
			<p>${memId }님 환영합니다.</p>
			<a href="logout.do">로그아웃</a><br>
			<a href="index.jsp?req=modifyForm">회원정보수정</a><br>
			<a href="index.jsp?req=memberList">회원목록</a><br>
			<a href="index.jsp?req=memberDelete">회원탈퇴</a><br>
		</c:if>
	</div>
	<div id="content">
		<c:if test="${param.req == null }">
			<img alt="그림" src="image/lion.jpg">g
		</c:if>
		<c:if test="${param.req != null }">
			<c:import url="${param.req }.do" charEncoding="utf-8"/>
		</c:if>
	</div>
	<div id="footer" align="center">
		EZEN Academy
	</div>
</body>
</html>