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
	<table border="1" width="1000">
		<tr>
			<th colspan="2">
				<img alt="라이언" src="../image/lion.png" width="50" style="display: inline-block;">
				<h2 style="display: inline-block;">Spring을 이용한 미니프로젝트</h2><br>
				<c:if test="${memId != null }">
					<a href="boardWriteForm.do">글쓰기</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<a href="board.do">목록</a>
			</th>
		</tr>
		<tr>
			<td width="300" height="500" valign="top">
				<c:if test="${nav == null }">
					<c:import url="loginForm.do"/>
				</c:if>
				<c:if test="${nav != null }">
					<c:import url="${nav }.do"/>
				</c:if>
			</td>
			<td valign="top">
				<c:if test="${con == null }">
					<h2 align="center">메인화면</h2>
					<img alt="라이언" src="../image/lion.png" width="200">
				</c:if>
				<c:if test="${con != null }">
					<c:import url="${con }.do"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="50">
				KGITBANK
			</td>
		</tr>
	</table>
	<!-- 로그인 전/후 화면 분리 -->
	<!-- 
	<h3>*** 메인 화면 ***</h3>
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
	-->
</body>
</html>