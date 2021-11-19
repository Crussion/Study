<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥 주문상세내역</title>
<link rel="stylesheet" type="text/css" href="../css/member_orderDetailList_css.css?v=1">
</head>
<body>
	<header>
		<div class="flex">
			<a href="member_logout.do">로그아웃 </a>|
			<a href="../member/member_mypage.jsp">예치금 : ${mem_deposit }원 </a>|
			<a href="../member/member_mypage.jsp"> 마이페이지 </a>|
			<a href="https://www.instagram.com/hansot_official/">
				<img src="../img/insta.png" width=14px height=14px style="max-width: 100%; height: auto;">
			</a>
			<a href="https://www.facebook.com/hansotOfficial/?ref=ts&fref=ts">
				<img src="../img/face.png" width=18px height=18px style="max-width: 100%; height: auto;">
			</a>
		</div>
		<div class="main_top_list">
			<div class="logo">
				<a href="../main/main.jsp"><img src="../img/DS2.png"></a>
			</div>
			<div class="top_list">
				<ul>
					<li class="mtl"><a href="#">BRAND</a></li>
					<li class="mtl"><a href="menuList.do">MENU</a></li>
					<li class="mtl"><a href="loca_list.do?pg=1">STORE</a></li>
					<li class="mtl"><a href="event_list.do?pg=1">EVENT</a></li>
					<li class="mtl"><a href="#">QnA</a></li>
				</ul>
			</div>
		</div>
	</header>
	<div class="content">
		<div class="container">
			<div class="subject" align="center">
				<span class="title">주문상세내역</span>
			</div>
   		</div>
   		<table id="list_head">
			<tr>
				<th width="180" height="60">상품명</th>
				<th width="400">상품정보</th>
				<th width="100">주문갯수</th>
				<th width="100">가격</th>
				<th width="80"></th>
			</tr>
		</table>
   		<fieldset>
			<form>
				<table>
					<tr>
						<td width="180" height="60">xxx</td>
						<td width="400">상품사진, 상품정보</td>
						<td width="100">갯수</td>
						<td width="100">총가격</td>
						<td width="80"><div id="order_cancel"><a href="">주문취소</a></div></td>
					</tr>
					<!-- 5개씩 보여주고 상품정보란에 마우스 올리면 상세정보 나오게설정
						상세정보가 보여지면서 .content의 세로 길이가 길어져서 footer에 침입하게되므로
						jquery로 세로길이 조정 -->
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
			<br><br>
			<hr style="border: 1px solid dimgray;">
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