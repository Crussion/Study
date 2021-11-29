<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 상세 보기</title>
<link rel="stylesheet" type="text/css" href="../css/main_page2.css">
<style type="text/css">
#qna_view {
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
				<span class="title">QnA 상세보기</span>
			</div>
		</div>
			<table id="qna_view">
				<tr align="center"> 
					<th class="qna_title">제목 : ${dto.qna_subject}</th>
				</tr>
				<tr align="center"> 
					<th class="qna_title">글번호 : ${dto.qna_seq}</th>
				</tr>
				<tr align="center"> 
					<th class="qna_content">내용 : ${dto.qna_content}</th>
				</tr>
				<tr align="center"> 
					<th class="qna_id">작성자 : ${dto.qna_id}</th>
				</tr>
				<tr align="center">
					<th class="qna_date">${dto.qna_date}</th>
				</tr>			
			</table>
			<table id=qna_re_view>
				<tr align="center">
					<th class="reCont">답변 내용 : ${redto.qna_reCont}</th>
				</tr>
				<tr align="center">
					<th class="reDate">답변일 : ${redto.qna_reDate}</th>
				</tr>
			</table>
			<div>
				<input type="button" value="글목록"
					onclick="location.href='qnaList.do?pg=${pg}'"> 
				<input type="button" value="글 답변"
					onclick="location.href='qnaReplyForm.do?pg=${pg}&qna_seq=${qna_seq}'">
			</div>
		</div>
</body>
</html>