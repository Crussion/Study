<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 목록</title>
<link rel="stylesheet" type="text/css" href="../css/main_page2.css">
<style type="text/css">
#QnA_list {
	border: 1;
	height: 100px;
	width: 900px;
	margin: 0 auto;
}

.paging {
	text-align: center;
}

caption {
	padding-top: 0;
	padding-bottom: 30px;
	font-size: 30px;
}

.CustomerSoundsWrite {
	text-align: right;
}

.Return {
	text-align: left;
}
</style>
</head>
<body>
	<header>
		<div class="flex">
			<a href="member/member_login.jsp">로그인 </a>|
			<a href="member/member_join.jsp"> 회원가입 </a>|
			<a href="https://www.instagram.com/hansot_official/?hl=ko"> 인스타</a>
			<a href="https://ko-kr.facebook.com/hansotOfficial/">페이스북</a>
		</div>
		<div class="top">
			<div class="main_top_list">
				<div class="logo">
					<a href="main.jsp"><img src="../img/DS2.png"></a>
				</div>
				<div class="top_list">
					<ul>
						<li class="mtl"><a href="*">BRAND</a></li>
						<li class="mtl"><a href="#">MENU</a></li>
						<li class="mtl"><a href="#">STORE</a></li>
						<li class="mtl"><a href="#">EVENT</a></li>
						<li class="mtl"><a href="#">FRANCHISE</a></li>
						<li class="mtl"><a href="FAQList.do?pg=1">QnA</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<div class="content">
		<div class="container">
		</div>
		<table id="QnA_list">
			<caption>문의 내역</caption>
			<tr bgcolor="lightgray">	
				<th width="70">글번호</th>
				<th>제목</th>
				<th width="100">작성자</th>
				<th width="100">작성일</th>
			</tr>
		<c:forEach var="qnadto" items="${list}">
		<tr align="center">
			<td>${qnadto.qna_seq}</td>
			<td>
				<a id="subjectA" href="qnaView.do?pg=${pg}&qna_seq=${qnadto.qna_seq}">${qnadto.qna_subject}</a>
			</td>
			<td>${qnadto.qna_id}</td>
			<td>${qnadto.qna_date}</td>
		</tr>
		</c:forEach>
			<!-- 페이징 -->
			<tr>
				<td colspan="5" align="center">
				<c:if test="${startPage > 3 }">
					[<a class="paging" href="qnaList.do?pg=${startPage-1}">이전</a>]
				</c:if>
				
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${pg==i}">
						[<a class="currentPaging" href="qnaList.do?pg=${i}">${i}</a>]
					</c:if>
					<c:if test="${pg!=i}">
						[<a class="Paging" href="qnaList.do?pg=${i}">${i}</a>]
					</c:if>
				</c:forEach>
				<c:if test="${endPage < totalP}">
					[<a href="qnaList.do?pg=${endPage+1}">다음</a>]
				</c:if>
				</td>
			</tr>
		</table>
		<div class="QnAWrite">
			<a href="../qna/qna_WriteForm.jsp">글쓰기</a>
		</div>
		<div class="Return">
			<!--  
			<a href=".jsp">마이페이지로 돌아가기</a>
			-->
		</div>		
	</div>
	<footer></footer>	
</body>
</html>