<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/cartList.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".list").first().css("border-top", "none")
		$(".qty_minus").click(function(){
			var qty = $(this).parents(".list_con").find(".qty").html()
			var price = 7000
			if(qty > 0){
				$(this).parents(".list_con").find(".qty").html(--qty)
				$(this).parents(".list_con").find(".menu_price").html(qty * price)
			}
		})
		$(".qty_plus").click(function(){
			var qty = $(this).parents(".list_con").find(".qty").html()
			var price = 7000
			if(qty < 1){
				qty = 1
				$(this).parents(".list_con").find(".qty").html(qty)
				$(this).parents(".list_con").find(".menu_price").html(qty * price)
			}else{
				$(this).parents(".list_con").find(".qty").html(++qty)
				$(this).parents(".list_con").find(".menu_price").html(qty * price)
			}
		})
	})
</script>
</head>
<body>
	<header>
		<div class="flex">
			<a href="member/member_login.jsp">로그인 </a>|
			<a href="member/member_join.jsp"> 회원가입 </a>|
			<a href="#"> 인스타</a>
			<a href="#">페이스북</a>
		</div>
		<div class="main_top_list">
			<div class="logo">
				<a href="main.jsp"><img src="img/DS2.png"></a>
			</div>
			<div class="top_list">
				<ul>
					<li class="mtl"><a href="*">BRAND</a></li>
					<li class="mtl"><a href="../menu/menuList.do">MENU</a></li>
					<li class="mtl"><a href="#">STORE</a></li>
					<li class="mtl"><a href="#">EVENT</a></li>
					<li class="mtl"><a href="#">FRANCHISE</a></li>
					<li class="mtl"><a href="#">QnA</a></li>
				</ul>
			</div>
		</div>
		<div class="main_photo"></div>
	</header>
	<div class="container">
		<div class="subject" align="center">
			<span class="title">장바구니</span>
		</div>
	</div>
	<div class="content">
		<div id="con">
			<div class="list">
				<div class="img">
					<img alt="사진" src="../menu_image/new.jpg">
				</div>
				<div class="list_con">
					<p id="menu_name">음식명음식명음식명음식명</p>
					<div id="cart_qty"><span>수량:</span>
						<div class="qty_minus">&lt;</div>
						<span class="qty">1</span>
						<div class="qty_plus">&gt;</div>
					</div>
					<br>
					<div class="menu_price">
						7000
					</div>
					<div>원</div>
				</div>
			</div>
			<div class="list">
				<div class="img">
					<img alt="사진" src="../menu_image/new.jpg">
				</div>
				<div class="list_con">
					<p id="menu_name">음식명음식명음식명음식명</p>
					<div id="cart_qty"><span>수량:</span>
						<div class="qty_minus">&lt;</div>
						<span class="qty">1</span>
						<div class="qty_plus">&gt;</div>
					</div>
					<br>
					<div class="menu_price">
						7000
					</div>
					<div>원</div>
				</div>
			</div>
		<!-- 
			<c:forEach var="dto" items="${list }">
				<div class="list">
					<img alt="사진" src="../menu_image/${dto.menu_img }" class="img">
				</div>
			</c:forEach>
		-->
		</div>
	</div>
	<footer>
	
	</footer>
</body>
</html>