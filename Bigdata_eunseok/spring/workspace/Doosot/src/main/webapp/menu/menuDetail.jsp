<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <%-- jstl 함수 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/menuDetail.css?v=2">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function qty_plus(price){
		var qty = $("#food_qty").html()
		if(qty < 1){
			var qty = 1
			$("#food_qty").html(qty)
			$("#con_p4").html(qty * price)
		}else{
			$("#food_qty").html(++qty)
			$("#con_p4").html(qty * price)
		}
	}
	function qty_minus(price){
		var qty = $("#food_qty").html()
		if(qty > 0){
			$("#food_qty").html(--qty)
			$("#con_p4").html(qty * price)
		}
	}
	$(function(){
		$(".qty_btn").hover(function(){
			$(this).css("background-color", "#f0b400")
		},function(){
			$(this).css("background-color", "orange")
		})
		$("#menuModify").click(function(){
			location.href = "menuModifyForm.do?menu_num=" + ${dto.menu_num } + "&menu_category=" + "${category }"
		})
		$("#menuDelete").click(function(){
			location.href = "menuDelete.do?menu_num=" + ${dto.menu_num } + "&menu_category=" + "${category }"
		})
		$(".title").click(function(){
			location.href = "menuList.do?menu_category=" + "${category }"
		})
		$("#put_cart").click(function(){
			if("${login_id }" == ""){
				alert("로그인이 필요합니다.")
			}else{
				$.post("add_cart.do", {
					cart_qty: $("#food_qty").html(),
					mem_id: "${login_id }",
					menu_num: ${dto.menu_num }
				},function(result){
					if(result != null){
						alert("장바구니에 추가 했습니다.")
					}else{
						alert("장바구니에 담지 못했습니다.")
					}
				}).fail(function(result){
					alert("잠시 후 시도해 주세요.")
				})
				return false
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
			<span class="title">← 전체 메뉴</span>
		</div>
	</div>
	<div class="content">
		<div id="content">
			<div id="img"><img alt="음식 이미지" src="../menu_image/${dto.menu_img }"></div>
			<div id="con">
				<p id="con_p1">${dto.menu_category }</p><!-- 음식 카테고리 -->
				<p id="con_p2">${dto.menu_name }</p><!-- 음식 이름 -->
				<div id="con_line1"></div>
				<p id="con_p3">${dto.menu_content }</p><!-- 음식 설명 -->
				<div id="con_line2"></div>
				<div id="price">
					<span id="con_p4">${dto.menu_price }</span><span id="won">원</span><!-- 음식 가격 -->
				</div>
				<div id="qty">
					<span>수량</span>
					<div class="qty_btn" id="qty_minus" onclick="qty_minus(${dto.menu_price })">&lt;</div>
					<span id="food_qty">1</span>
					<div class="qty_btn" id="qty_plus" onclick="qty_plus(${dto.menu_price })">&gt;</div>
				</div>
				<div class="btn_list">
					<div class="btn" id="put_cart">장바구니</div>
					<div class="btn" id="set_order">주문하기</div>
				</div>
			</div>
		</div>
	</div>
	<div id="detail">
		<div id="kcal">
			<div class="detail_line"></div>
			<span class="detail_text">열량</span><br>
			<span id="kcal_cal">${dto.menu_kcal }</span>
			<span id="kcal_text">Kcal</span>
		</div>
		<div id="allergy">
			<div class="detail_line"></div>
			<span class="detail_text">알레르기</span><br>
			<table>
				<tr id="category">
					<c:forEach var="ingre" items="${ingre_list }">
						<td width="66.67" style="font-size: 0.8em;">${ingre }</td>
					</c:forEach>
				</tr>
				<tr id="alg_have">
					<c:forEach var="i" begin="0" end="17" step="1">
						<c:if test="${fn:indexOf(dto.menu_ingre, ingre_list[i]) != -1 }">
							<td>○</td>
						</c:if>
						<c:if test="${fn:indexOf(dto.menu_ingre, ingre_list[i]) == -1}">
							<td>△</td>
						</c:if>
					</c:forEach>
				</tr>
			</table>
			<p><span style="font-size: 1.5em; margin: 15px 12px;">○</span>해당 알레르기 성분이 포함되어 있음</p>
			<p><span style="font-size: 1.7em; margin: 10px 10px;">△</span>해당 알레르기 성분이 직접적으로 포함되어 있지 않지만, 해당 성분을 가공하는 시설에서 가공/제조 하였음</p>
			<p><span style="font-size: 2.4em; margin: 10px 10px;">×</span>해당 알레르기 성분이 포함되어 있지 않음</p>
		</div>
	</div>
	<c:if test="True">
		<div class="admin_bar">
			<div class="admin_bar_list">
				<div class="bar_btn" id="menuModify">음식 수정</div>
				<div class="bar_btn" id="menuDelete">음식 삭제</div>
			</div>
		</div>
	</c:if>
	<footer>
	
	</footer>
</body>
</html>