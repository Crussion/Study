<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 관리</title>
<style type="text/css">
body { margin:0; }
#header { text-align: center; border: 1px solid black;}
#nav { float:left; width: 200px; height: 500px; background: lightgreen; }
#footer { text-align: center; clear: both; border: 1px solid black; }
</style>
</head>
<body>
	<div id="header">
		<h1>책 관리</h1>
	</div>
	<div id="nav">
		<h3><a href="index.jsp">** 메인화면 **</a></h3>
		<p><a href="bookWriteForm.do">도서 입력</a></p>
		<p><a href="bookList.do">도서 목록</a></p>
	</div>
	<div id="section">
		<c:choose>
			<c:when test="${req != null }">
				<c:import url="${req }"></c:import>
			</c:when>
			<c:otherwise>
				<img alt="책 그림" src="image/img.jpg" width="400">
			</c:otherwise>
		</c:choose>
	</div>
	<div id="footer">
		<p>장은석</p>
	</div>
</body>
</html>