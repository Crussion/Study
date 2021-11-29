<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link rel="stylesheet" type="text/css" href="../css/main_page2.css">
<style type="text/css">
#faq_view {
	padding-top: 30px;
	border: 1;
	height: 100px;
	width: 900px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<header>
		<div class="flex">
			<a href="member/member_login.jsp">로그인 </a>| <a
				href="member/member_join.jsp"> 회원가입 </a>| <a
				href="https://www.instagram.com/hansot_official/?hl=ko"> 인스타</a> <a
				href="https://ko-kr.facebook.com/hansotOfficial/">페이스북</a>
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
						<li class="mtl"><a href="FAQ/FAQList.do?pg=1">QnA</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<div class="content">
		<div class="container">
			<div class="subject" align="center">
				<span class="title">FAQ 상세보기</span>
			</div>
		</div>
			<table id="faq_view">
				<tr align="center">
					<th class="faq_title">제목 : ${dto.faq_subject}</th>
				</tr>
				<tr align="center">
					<th>글번호 : ${dto.faq_seq}</th>
				</tr>
				<tr align="center">
					<th>
					<img alt="이미지" src="../fileupload/${dto.faq_img}" width="500" height="300">
					</th>
				</tr>			
				<tr align="center">
					<th>내용 : ${dto.faq_content}</th>
				</tr>
				<tr align="center">	
					<th>작성자 : ${dto.faq_id}</th>
				</tr>
				<tr align="center">
					<th class="faq_date">작성일 : ${dto.faq_date}</th>
				</tr>
			</table>

			<div>
				<input type="button" value="글목록"
					onclick="location.href='FAQList.do?pg=${pg}'"> 
				<input type="button" value="글 수정"
					onclick="location.href='FAQModifyForm.do?pg=${pg}&faq_seq=${faq_seq}'">
			</div>
		</div>
</body>
</html>