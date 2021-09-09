<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.paging{color:blue; text-decoration: none; }
.currentPaging{color:red; text-decoration: underline; font-size: 1.2em;}
</style>
</head>
<body>
	<table board="1" width="800" style="margin: auto;" border="1">
		<tr>
			<th>번호</th>
			<th width="100">이미지</th>
			<th width="100">상품명</th>
			<th>단가</th>
			<th>개수</th>
			<th>합계</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr align="center">
				<td>${dto.seq }</td>
				<td><img alt="그림" src="../storage/${dto.image1 }" width="100"></td>
				<td><a href="imageboardView?seq=${dto.seq }&pg=${pg }">${dto.imageName }</a></td>
				<td>${dto.imagePrice }</td>
				<td>${dto.imageQty }</td>
				<td>${dto.imagePrice * dto.imageQty }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">
				<c:if test="${startPage > 3 }">
					[<a class="paging" href="imageboardList?pg=${startPage-1}">이전</a>]
				</c:if>
				
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<c:if test="${pg == i }">
						[<a class = "currentPaging" href="imageboardList?pg=${i }">${i }</a>]
					</c:if>
					<c:if test="${pg != i }">
						[<a class="paging" href="imageboardList?pg=${i }">${i }</a>]
					</c:if>
				</c:forEach>
				
				<c:if test="${endPage < totalP }">
					[<a class="paging" href="imageboardList?pg=${endPage+1}">다음</a>]
				</c:if>
				</td>
		</tr>
	</table>
	<a href="imageboardWriteForm">이미지 등록</a>
</body>
</html>