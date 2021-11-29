<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 답변 작성</title>
<link rel="stylesheet" type="text/css" href="../css/main_page2.css">
<style type="text/css">
#re {
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
				<span class="title">고객의 소리</span>
			</div>
		</div>
		<form action="qnaReply.do?pg=${pg}&qna_seq=${qna_seq}" id="frm"
			name="QnA_frm" method="post" enctype="multipart/form-data">
			<table id="re">
				<tr align="center">
					<th>글번호</th>
					<td><input type="text" name="qna_seq" size="80" class="input"
						value="${dto.qna_seq}" readonly></td>
				</tr>
				<tr align="center">
					<th>제목</th>
					<td><input type="text" name="qna_subject" size="80" class="input"
						value="${dto.qna_subject}" readonly></td>
				</tr>
				<tr align="center">
					<th>내용</th>
					<td><textarea rows="20" cols="76" name="qna_reCont"
							placeholder="내용을 입력해주세요"></textarea></td>
				</tr>
				<tr align="center">
					<th>아이디</th>
					<td><input type="text" name="qna_reId" size="80" class="input"
						placeholder="아이디를 입력해주세요"></td>
				</tr>
				<tr align="center">
					<td colspan="2">
					<input type="submit" value="답변달기"> 
					<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
		<div class="QnAList">
			<!--  
			<a href="QnAList.jsp">목록보기</a>
			-->
		</div>
	</div>
	<footer> </footer>
</body>
</html>