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
#nav { width: 200px; height: 500px; float: left; background: orange; }
#nav > a { text-decoration: none; }
#footer { border: 1px solid black; clear: both; height: 50px; }
</style>
</head>
<body>
	<div align="center" id="header">
		<h1>게시판</h1>
	</div>
	<div id="nav">
		<h2><a href="index.jsp">*** 메인 화면 ***</a></h2>
		<p><a href="index.jsp?req=boardWriteForm">글 쓰기</a></p>
		<p><a href="index.jsp?req=boardList">글 목록</a></p>
	</div>
	<div id="content">
		<c:choose>
			<c:when test="${param.req == 'boardWriteForm' }">
				<c:import url="boardWriteForm.do" charEncoding="utf-8"/>
			</c:when>
			<c:when test="${param.req == 'boardList' }">
				<c:import url="boardList.do" charEncoding="utf-8"/>
			</c:when>
			<c:when test="${param.req == 'boardDetail' }">
				<c:import url="boardDetail.do" charEncoding="utf-8"/>
			</c:when>
			<c:when test="${param.req == 'boardReplyForm' }">
				<c:import url="boardReplyForm.do" charEncoding="utf-8"/>
			</c:when>
			<c:when test="${param.req == 'boardModifyForm' }">
				<c:import url="boardModifyForm.do" charEncoding="utf-8"/>
			</c:when>
			<c:when test="${param.req == 'boardDeleteForm' }">
				<c:import url="boardDeleteForm.do" charEncoding="utf-8"/>
			</c:when>
			<c:otherwise>
				<img alt="라이언" src="image/lion.jpg">
			</c:otherwise>
		</c:choose>
	</div>
	<div align="center" id="footer">
		KGITBANK
	</div>
</body>
</html>