<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 수정</title>
<link rel="stylesheet" type="text/css" href="../css/main_page2.css">
<style type="text/css">
#modifywriteform {
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
		<div class="top"></div>
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
			<div class="subject" align="center">
				<span class="title">FAQ 수정</span>
			</div>
		</div>
		<form action="FAQModify.do?pg=${pg}" id="frm"
			name="FAQ_frm" method="post" enctype="multipart/form-data">
			<table id="modifywriteform">
				<tr align="center">
					<th>글번호</th>
					<td><input type="text" name="faq_seq" size="80" class="input"
						value="${dto.faq_seq}" readonly></td>
				</tr>
				
				<tr align="center">
					<th>제목</th>
					<td><input type="text" name="faq_subject" size="80" class="input"
						value="${dto.faq_subject}" placeholder="제목을 입력해주세요"></td>
				</tr>
				<tr align="center">
					<th>내용</th>
					<td><textarea type="text" rows="20" cols="76" name="faq_content"
							class="input" value="${dto.faq_content}" placeholder="내용을 입력해주세요"></textarea></td>					
				</tr>
				<tr align="center">
					<th>이미지</th>
					<td><input type="file" class="input" name="faq_img" id="file" size="40"
						value="${dto.faq_img}"></td>
				</tr>
				<tr align="center">
					<th>아이디</th>
					<td><input type="text" name="faq_id" size="80" class="input"
						value="${dto.faq_id}" placeholder="아이디를 입력해주세요" readonly></td>
				</tr>
				<tr align="center">
					<td colspan="2">
					<input type="submit" value="FAQ 수정" class="faq">
					<input type="reset" value="다시 작성" class="faq">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<footer> </footer>
</body>
</html>