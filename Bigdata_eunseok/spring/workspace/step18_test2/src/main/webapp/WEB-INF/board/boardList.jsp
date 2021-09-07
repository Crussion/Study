<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 로그인 되어 있는 지 검사해서, 상세보기로 이동함
	function isLogin(seq) {
		if(${memId == null}){ 
			alert("먼저 로그인 하세요");
		} else {
			location.href = "boardView.do?seq=" + ${seq} + "&pg=" + ${pg};
		}
	}
</script>
<style type="text/css">
#subjectA:link {color:black; text-decoration: none;}
#subjectA:visited {color:black; text-decoration: none;}
#subjectA:hover {color:green; text-decoration: underline;}
#subjectA:active {color:black; text-decoration: none;}

.paging {color: blue; text-decoration: none;}
.currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
	<table border="1" width="550" style="margin:auto;">
		<tr bgcolor="orange">
			<th width="70">글번호</th>
			<th>제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>
		
		<c:forEach var="dto" items="${list }">
			<tr align="center" bgcolor="#ffffcc">
				<td>${dto.seq }</td>
				<td><a id="subjectA" href="#" onclick="isLogin(${dto.seq})">
						${dto.subject }</a></td>
				<td>${dto.id}</td>
				<td>${dto.logtime}</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>
		
		<!-- 페이징 -->
		<tr>
			<td colspan="5" align="center">
				<c:if test="${startPage > 3 }">
					[<a class="paging" href="boardList.do?pg=${startPage-1}">이전</a>]
				</c:if>
				
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<c:if test="${pg == i }">
						[<a class="currentPaging" href="boardList.do?pg=${i }">${i }</a>]
					</c:if>
					<c:if test="${pg != i }">
						[<a class="paging" href="boardList.do?pg=${i }">${i }</a>]
					</c:if>
				</c:forEach>
			
				<c:if test="${endPage < totalP }">
					[<a class="paging" href="boardList.do?pg=${endPage+1}">다음</a>]
				</c:if>
			</td>
		</tr>
	</table>
	
	<c:if test="${memId == null }">
		<a href="loginForm.do">로그인</a>
	</c:if>
	<c:if test="${memId != null }">
		<a href="boardWriteForm.do">글쓰기</a>
	</c:if>
</body>
</html>