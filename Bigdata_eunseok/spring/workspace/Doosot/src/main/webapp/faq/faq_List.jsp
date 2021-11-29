<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 목록보기</title>
<link rel="stylesheet" type="text/css" href="../css/main_page2.css">
<style type="text/css">
#FAQ_list {
	border: 1;
	height: 100px;
	width: 900px;
	margin: 0 auto;
}

.QnA_right {
	padding-right: 10px;
	padding-top: 5px;
	text-align: right;
	font-size: 18px;
}

caption {
	padding-top: 0;
	padding-bottom: 30px;
	font-size: 30px;
}

.paging {
	text-align: center;
}

.FAQWriteForm {
	text-align: right;
}
.a {
	text-align: right;
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
						<li class="mtl"><a href="faqList.do?pg=1">QnA</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<div class="content">
		<div class="container">
			<div class="subject" align="center">
				<span class="title">QnA</span>
				<div class="QnA_right">
					<a href="faqList.do?pg=1">FAQ</a> 
					<a href="qnaList.do?pg=1">고객의 소리</a>
				</div>
			</div>
		</div>
		<table id="FAQ_list">
			<caption>FAQ 리스트</caption>
			<tr bgcolor="lightgray">
				<th width="70">글번호</th>
				<th>제목</th>
				<th width="100">작성자</th>
				<th width="100">작성일</th>
			</tr>
		<c:forEach var="faqdto" items="${list}">
			<tr align="center">
				<td>${faqdto.faq_seq}</td>
				<td><a id="subjectA" href="faqView.do?pg=${pg}&faq_seq=${faqdto.faq_seq}">${faqdto.faq_subject}</a></td>
				<td>${faqdto.faq_id}</td>
				<td>${faqdto.faq_date}</td>
			</tr>
		</c:forEach>
			<!-- 페이징 -->
			<tr>
				<td colspan="5" align="center">
				<c:if test="${startPage > 3 }">
					[<a class="paging" href="faqList.do?pg=${startPage-1}">이전</a>]
				</c:if>
				
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${pg==i}">
						[<a class="currentPaging" href="faqList.do?pg=${i}">${i}</a>]
					</c:if>
					<c:if test="${pg!=i}">
						[<a class="Paging" href="faqList.do?pg=${i}">${i}</a>]
					</c:if>
				</c:forEach>
				
				<c:if test="${endPage < totalP}">
					[<a href="faqList.do?pg=${endPage+1}">다음</a>]
				</c:if>
				</td>
			</tr>
		</table>
	<div class="a">
		<a href="faqWriteForm.jsp?pg=${pg}">글쓰기</a>	
	</div>	
	</div>
	<footer></footer>
</body>
</html>