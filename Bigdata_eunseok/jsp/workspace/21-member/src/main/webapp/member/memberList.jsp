<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.paging { color: blue; text-decoration: none; }
.currentPaging { color: red; text-decoration: underline; }
</style>
</head>
<body>
	<table border="1" width="690">
		<tr bgcolor="yellow">
			<th width="100">이름</th>
			<th>아이디</th>
			<th width="50">성별</th>
			<th width="150">이메일</th>
			<th width="140">전화번호</th>
			<th width="150">가입일</th>
		</tr>
		<c:forEach var="bean" items="${list }">
			<tr>
				<td>${bean.getName() }</td>
				<td>${bean.getId() }</td>
				<td>${bean.getGender() }</td>
				<td>${bean.getEmail1() } @ ${bean.getEmail2() }</td>
				<td>${bean.getTel1() } - ${bean.getTel2() } - ${bean.getTel3() }</td>
				<td>${bean.getLogtime() }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">
				<c:if test="${startPage > 3 }">
					[<a class="paging" href="index.jsp?req=memberList&pg=${startPage-1 }">이전</a>]
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<c:if test="${pg == i }">
						[<a class="currentPaging" href="index.jsp?req=memberList&pg=${i }">${i }</a>]
					</c:if>
					<c:if test="${pg != i }">
						[<a class="paging" href="index.jsp?req=memberList&pg=${i }">${i }</a>]
					</c:if>
				</c:forEach>
				<c:if test="${endPage < total_page }">
					[<a class="paging" href="index.jsp?req=memberList&pg=${endPage+1 }">다음</a>]
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>