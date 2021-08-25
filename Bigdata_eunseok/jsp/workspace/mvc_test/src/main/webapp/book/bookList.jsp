<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</style>
</head>
<body>
	<table border="1">
		<tr bgcolor="yellow">
			<th width="100">도서코드</th>
			<th width="200">도서명</th>
			<th width="100">저자</th>
			<th width="150">출판사</th>
			<th width="140">가격</th>
			<th width="150">출판일</th>
		</tr>
		<c:forEach var="bean" items="${list }">
			<tr>
				<td>${bean.book_num }</td>
				<td>${bean.book_subject }</td>
				<td>${bean.book_writer }</td>
				<td>${bean.book_publisher }</td>
				<td>${bean.book_price }</td>
				<td>${fn:split(bean.book_date,' ')[0] }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">
				<c:if test="${startPage > 5 }">
					[<a class="paging" href="bookList.do?pg=${startPage-1 }">이전</a>]
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<c:if test="${pg == i }">
						[<a class="currentPaging" href="bookList.do?pg=${i }">${i }</a>]
					</c:if>
					<c:if test="${pg != i }">
						[<a class="paging" href="bookList.do?pg=${i }">${i }</a>]
					</c:if>
				</c:forEach>
				<c:if test="${endPage < total_page }">
					[<a class="paging" href="bookList.do?pg=${endPage+1 }">다음</a>]
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>