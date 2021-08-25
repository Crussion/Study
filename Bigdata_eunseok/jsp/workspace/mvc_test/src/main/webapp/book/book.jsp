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
	<c:if test="${result > 0}">
		<p>등록 성공</p>
		<p>도서코드 : ${bean.book_num }</p>
		<p>도서명 : ${bean.book_subject }</p>
		<p>저자 : ${bean.book_writer }</p>
		<p>출판사 : ${bean.book_publisher }</p>
		<p>가격 : ${bean.book_price }</p>
		<p>출판일 : ${bean.book_date }</p>
	</c:if>
	<c:if test="${result == 0 }">
		<p>등록 실패</p>
	</c:if>
</body>
</html>