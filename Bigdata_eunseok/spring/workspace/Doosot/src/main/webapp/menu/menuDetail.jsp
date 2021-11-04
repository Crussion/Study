<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/menuDetail.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#qty_minus").click(function(){
			var qty = $("#food_qty").html()
			if(qty > 0){
				$("#food_qty").html(--qty)
				var price = 5600 //음식 가격 \${menu_price }
				$("#con_p4").html(qty * price)
			}
		})
		$("#qty_plus").click(function(){
			var qty = $("#food_qty").html()
			if(qty < 1){
				var qty = 1
				$("#food_qty").html(qty)
				var price = 5600 //음식 가격 \${menu_price }
				$("#con_p4").html(qty * price)
			}else{
				$("#food_qty").html(++qty)
				var price = 5600 //음식 가격 \${menu_price }
				$("#con_p4").html(qty * price)
			}
		})
	})
</script>
</head>
<body>
	<header>
		<div class="flex"></div>
		<div class="top">
			<div class="main_top_list">
				<span>두솥</span>
				<ul>
					<li class="mtl"><a href="#">BRAND</a></li>
					<li class="mtl"><a href="#">MENU</a></li>
					<li class="mtl"><a href="#">STORE</a></li>
					<li class="mtl"><a href="#">EVENT</a></li>
					<li class="mtl"><a href="#">FRANCHISE</a></li>
					<li class="mtl"><a href="#">QnA</a></li>
				</ul>
			</div>
			<div class="main_photo"></div>
		</div>
	</header>
	<div class="container">
		<div class="subject" align="center">
			<div id="back"></div>
			<span class="title">전체 메뉴</span>
		</div>
	</div>
	<div class="content">
		<table id="content">
			<tr>
				<td id="img"><img alt="음식 이미지" src="../img/menu/new.jpg"></td>
				<td>
					<div id="con">
						<p id="con_p1">고기고기</p><!-- 음식 카테고리 -->
						<p id="con_p2">돈까스도련님고기고기</p><!-- 음식 이름 -->
						<div id="con_line1"></div>
						<p id="con_p3">돈까스와 떡햄버그, 치킨으로 구성된 도련님 
						도시락에 제육볶음과 소불고기를 더해 푸짐하고 
						가성비 좋은 도시락입니다.</p><!-- 음식 설명 -->
						<div id="con_line2"></div>
						<div id="price">
							<span id="con_p4">5600</span><span id="won">원</span><!-- 음식 가격 -->
						</div>
						<div id="qty">
							<span>수량</span>
							<div class="qty_btn" id="qty_minus">&lt;</div>
							<span id="food_qty">1</span>
							<div class="qty_btn" id="qty_plus">&gt;</div>
						</div>
						<div class="btn_list">
							<div class="btn" id="put_cart"
							onclick="">장바구니</div>
							<div class="btn" id="set_order"
							onclick="">주문하기</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<footer>
	
	</footer>
</body>
</html>