<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	window.onload = function(){
		if(${result > 0}){
			alert("저장 성공");
		}else if(${result == 0}){
			alert("저장 실패");
		}
	}
</script>
<style type="text/css">
#subjectA:link {color: black; text-decoration: none;}
#subjectA:visited {color: black; text-decoration: none;}
#subjectA:hover {color: green; text-decoration: underline;}
#subjectA:active {color: black; text-decoration: none;}

.paging {color: blue; text-decoration: none;}
.currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
	<table border="1" style="margin:auto;">
		<tr bgcolor="orange">
			<th width="120">학번</th>
			<th width="100">이름</th>
			<th width="70">국어</th>
			<th width="70">영어</th>
			<th width="70">수학</th>
			<th width="70">총점</th>
			<th width="70">평균</th>
		</tr>
	<c:forEach var="dto" items="${list }">
		<tr align="center">
			<td>${dto.studNo }</td>
			<td><a id="subjectA" href="scoreView.do?studNo=${dto.studNo }&pg=${pg }">
					${dto.name }</a></td>
			<td>${dto.kor }</td>
			<td>${dto.eng }</td>
			<td>${dto.mat }</td>
			<td>${dto.tot }</td>
			<td>${dto.avg }</td>
		</tr>
	</c:forEach>

	<!-- 페이징 -->
	<tr>
		<td colspan="7" align="center">
		<c:if test="${startPage > 3 }">
			[<a class="paging" href="scoreList.do?pg=${startPage-1 }">이전</a>]
		</c:if>
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<c:if test="${pg == i }">
				[<a class="currentPaging" href="scoreList.do?pg=${i }">${i }</a>]
			</c:if>
			<c:if test="${pg != i }">
				[<a class="paging" href="scoreList.do?pg=${i }">${i }</a>]
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage < tot_page }">
			[<a class="paging" href="scoreList.do?pg=${endPage+1 }">다음</a>]
		</c:if>
		</td>
	</tr>
	</table>
	<a href="scoreWriteForm.do">성적입력</a>
</body>
</html>