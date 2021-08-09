<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#subject:link {
	color:black; text-decoration: none;
}
#subject:visited {
	color:black; text-decoration: none;
}
#subject:hover {
	color:green; text-decoration: underline;;
}
#subject:active {
	color:black; text-decoration: none;
}

.paging { color: blue; text-decoration: none; }
.currentPaging { color: red; text-decoration: underline; }
</style>
</head>
<body>
	<table border="1" width="800">
		<tr>
			<th width="50">번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>단가</th>
			<th>개수</th>
			<th>합계</th>
		</tr>
		<c:forEach var="ary" items="${list }">
			<tr align="center">
				<td>${ary.seq }</td>
				<td>
					<a href="../imageboard/imageboardView.jsp?seq=${ary.seq }&pg=${pg }">
						<img alt="그림" src="../storage/${ary.image1 }" width="50">
					</a>
				</td>
				<td>
					<a id="subject" href="../imageboard/imageboardView.jsp?seq=${ary.seq }&pg=${pg }">
						${ary.imageName }
					</a>
				</td>
				<td>${ary.imagePrice }</td>
				<td>${ary.imageQty }</td>
				<td>${ary.imagePrice * ary.imageQty }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">
				<c:if test="${startPage > 3 }">
					[<a class="paging" 
							href="../imageboard/imageboardList.jsp?pg=${startPage - 1 }">
						이전</a>]
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<c:if test="${pg == i }">
						[<a class="currentPaging" 
							href="../imageboard/imageboardList.jsp?pg=${i }">${i }</a>]
					</c:if>
					<c:if test="${pg != i }">
						[<a class="paging" 
							href="../imageboard/imageboardList.jsp?pg=${i }">${i }</a>]
					</c:if>
				</c:forEach>
				<c:if test="${endPage < total_page }">
					[<a class="paging" 
							href="../imageboard/imageboardList.jsp?pg=${endPage }">
						다음</a>]
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>