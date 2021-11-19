<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥 문의내역</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}
html{
	height:100%;
}
body {
	margin: 0;
	background-color: #ececec;
}

.flex {
	position: relative;
	margin: 0 auto;
	padding-top:10px;
	width: 1200px;
	height: 30px;
	text-align: right;
	color: dimgray;
	z-index: 2;
}

.flex a {text-decoration: none;}
.flex a:link {color: dimgray;}
.flex a:visited {color: dimgray;}

.main_top_list {
	position: relative;
	margin: 0 auto;
	width: 1200px;
	height: 90px;
	background-color: white;
	z-index: 2;
}
.logo, .logo a, .logo p, .top_list{display:inline;}
.logo{margin-left:30px;}
.logo img{margin-top:21px;}

.top_list{float:right;}
.main_top_list ul li {
	list-style-type: none;
	float: left;
	margin-left: 40px;
}
.main_top_list ul li a{
text-decoration: none;
font-size:17px;
font-weight:bold;
}
.main_top_list ul li a:link{color: black;}
.main_top_list ul li a:visited{color: black;}
.main_top_list ul li a{padding:0 15px;}

.top_list{
padding-top:35px;
padding-right:66px;
}

.container{
	width: 1200px;
	height: 140px;
	margin: 50px auto;
	margin-bottom: 0;
	background-color: white;
	border-bottom: 2px solid #ececec;
}

.subject {
	width: 1200px;
	height: 140px;
}

.title {
	display:inline;
	font-size: 35px;
	font-weight: 550;
	float: left;
	padding-top: 55px;
	padding-left: 30px;
}

.title:after {
	clear: left;
}

.content {
	width: 1200px;
	height: 700px;
	margin: 30px auto;
	background-color: white;
}
#list_head{
	margin-top:30px;
	border:1px solid #ececec;
	color: dimgray;
}
fieldset{
	margin:0 auto;
	width:808px; 
	border:1px solid #ececec;
}
.content table{
	text-align: center;
	margin:0 auto;
}

th{font-size:20px;}

footer {
	width: 100%;
	height: 300px;
	margin: 0 auto;
	margin-top:30px;
	padding-top: 50px;
	background: orange;
}
footer p{text-align:center; color:#3D3D3D;}
#footer_head{width:1200px; margin:0 auto; font-size:17px; padding-bottom:20px; border-bottom:1px solid dimgray;}
#footer_foot{margin:0 auto; padding-top:30px;}
</style>
</head>
<body>
	<header>
		<div class="flex">
			<a href="">로그아웃 </a>|
			<a href="member_mypage.jsp">예치금 : xxxx원 </a>|
			<a href="member_mypage.jsp">마이페이지 </a>|
			<a href="member_manage.jsp"> 가입자관리 </a>|
			<a href="https://www.instagram.com/hansot_official/"> 인스타</a>
			<a href="https://www.facebook.com/hansotOfficial/?ref=ts&fref=ts">페이스북</a>
		</div>
		<div class="top">
			<div class="main_top_list">
				<div class="logo">
					<a href="../main.jsp"><img src="../img/DS2.png"></a>
				</div>
				<div class="top_list">
					<ul>
						<li class="mtl"><a href="#">BRAND</a></li>
						<li class="mtl"><a href="#">MENU</a></li>
						<li class="mtl"><a href="#">STORE</a></li>
						<li class="mtl"><a href="#">EVENT</a></li>
						<li class="mtl"><a href="#">FRANCHISE</a></li>
						<li class="mtl"><a href="#">QnA</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<div class="content">
		<div class="container">
			<div class="subject" align="center">
				<span class="title">문의내역</span>
			</div>
   		</div>
   		<table id="list_head">
			<tr>
				<th width="150" height="60">문의번호</th><th width="350">문의제목</th><th width="150">문의날짜</th><th width="150">답변상태</th>
			</tr>
		</table>
   		<fieldset>
			<form>
				<table>
					<tr><!-- 제목제목제목에 마우스올리면 아래로 스르륵 답변보여지기 -->
						<td width="150" height="60">xxx</td><td width="350">제목제목제목</td><td width="150">날짜</td><td width="150">답변유무</td>
					</tr>
				</table>
				<!-- <p>현재 주문된 상품이 없습니다.</p> -->
			</form>
		</fieldset>
		<div><!-- 페이징 -->
			<p><< 1 2 3 4 5>></p>
		</div>
	</div>
	<footer>
		<div id="footer_head">
			<p>인재채용 | 협력업체등록 | 공지사항 | 고객 센터 | 개인정보처리방침 | 이용약관</p>
		</div>
		<div id="footer_foot">
			<p>대표이사 홍길동 | 사업자등록번호 123-12-12345 | 서울 서초구 서초대로 77길 55,에이프로 스퀘어 3층(서초동) | T.02-1234-1234 | F.02-9876-9876</p>
			<p>E.doosot@naver.com | 두솥 도시락 고객센터 02-2345-2345 | 전국창업설명회 02-3456-3456 | 단체주문 4567-4567</p>
			<br>
			<p>COPYRIGHT (주)두솥.ALL RIGHT RESEVED</p>
		</div>
	</footer>
</body>
</html>