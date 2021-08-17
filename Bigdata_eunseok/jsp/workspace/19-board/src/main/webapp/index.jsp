<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>*** 메인 화면 ***</h3>
	
	<a href="boardWriteForm.do">게시판 글쓰기</a><br>
	<a href="boardList.do">게시판 목록</a><br>
	
	<c:if test="${result > 0 }">
		<p>글을 저장하였습니다.</p>
	</c:if>
	<c:if test="${result == 0 }">
		<p>글을 저장하는데 실패하였습니다</p>
	</c:if>
</body>
</html>