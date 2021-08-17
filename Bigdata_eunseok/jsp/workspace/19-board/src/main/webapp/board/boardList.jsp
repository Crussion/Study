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
	<table border="1" width="500">
		<tr>
			<td>게시번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="bean" items="${list }">
			<tr>
				<td>${bean.board_num }</td>
				<td>${bean.board_subject }</td>
				<td>${bean.board_name }</td>
				<td>${bean.board_date }</td>
				<td>${bean.board_readcount }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>