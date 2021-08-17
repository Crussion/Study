<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
	if(${delete > 0}){
		alert("삭제 성공");
	}else if(${delete == 0}){
		alert("삭제 실패");
	}
</script>
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
				<td><a href="boardDetail.do?pg=${pg }&board_num=${bean.board_num }">${bean.board_subject }</a></td>
				<td>${bean.board_name }</td>
				<td>${bean.board_date }</td>
				<td>${bean.board_readcount }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				<c:if test="${startPage > 3 }">
					[<a class="paging" 
							href="boardList.do?pg=${startPage - 1 }">
						이전</a>]
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<c:if test="${pg == i }">
						[<a class="currentPaging" 
							href="boardList.do?pg=${i }">${i }</a>]
					</c:if>
					<c:if test="${pg != i }">
						[<a class="paging" 
							href="boardList.do?pg=${i }">${i }</a>]
					</c:if>
				</c:forEach>
				<c:if test="${endPage < total_page }">
					[<a class="paging" 
							href="boardList.do?pg=${endPage }">
						다음</a>]
				</c:if>
			</td>
		</tr>
	</table>
	<a href="index.jsp">메인화면</a>
	<a href="boardWriteForm.do">글쓰기</a>
</body>
</html>