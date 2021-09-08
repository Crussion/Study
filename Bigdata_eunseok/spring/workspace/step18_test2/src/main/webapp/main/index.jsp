<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h3>*** 메인 화면 ***</h3>
	<!-- 로그인 전/후 화면 분리 -->
	<c:if test="${memId == null }">
		<a href="loginForm.do">로그인</a>
		<br>
		<a href="writeForm.do">회원가입</a>
		<br>
	</c:if>
	<c:if test="${memId != null }">
		<a href="boardWriteForm.do">글쓰기</a>
		<br>
		<a href="logout.do">로그아웃</a>
		<br>
		<a href="memberModifyForm.do">회원정보수정</a>
		<br>
		<a href="memberList.do">회원목록보기</a>
		<br>
	</c:if>
	<a href="boardList.do">글목록</a>
	<br>
</body>
</html>