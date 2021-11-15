<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css?v=1">
<link rel="stylesheet" type="text/css" href="../css/menuList.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function goDetail(num){
		location.href = "menuDetail.do?menu_num=" + num + "&category=" + cat
	}
	
	function loadCategory(category){
		$.ajax({
			url: "menuList.do",
			type: "post",
			dateType: "html",
			data:{
				menu_category: category
			},
			cache: false,
			timeout: 30000,
			success: function(html){
				var page = $(html)
				var con = page.find("#con")
				con.find("#category").html($(".filter > select > option:selected").html())
				$("#con").html(con.html())
				$.each($(".food"), function(index){
					if(index % 3 == 1){
						$(this).addClass("list_mid")
					}
				})
			},
			fail: function(xhr, textStatus, errorThrown){
				alert(xhr.status)
			}
		})
	}

	$(function(){
		if("${category }" == ""){
			cat = $(".filter > select > option:selected").val()
		}else{
			cat = "${category }"
			$.each($(".filter > select > option"), function(){
				if($(this).attr("value") == cat){
					$(this).attr("selected", "selected")
				}
			})
		}
		
		loadCategory(cat)
		
		$(".filter > select").change(function(){
			cat = $(".filter > select > option:selected").val()
			
			loadCategory(cat)
			
			return false
		})
		
		$("#menuWriteForm").click(function(){
			location.href = "menuWriteForm.do"
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
			<span class="title">두솥 메뉴</span>
			<span class="filter">
				<select>
					<option value="total">전체</option>
					<option value="고기고기">고기고기</option>
					<option value="마요">마요</option>
				</select>
			</span>
		</div>
	</div>
	<div class="content">
		<div id="con">
			<span id="category">전체</span>
			<div id="menu_table">
				<c:forEach var="dto" items="${list }">
					<table class="food" onclick="goDetail(${dto.menu_num })">
						<tr>
							<td width="300px" height="250px"><img alt="음식 사진" src="../menu_image/${dto.menu_img }" class="img"></td>
						</tr>
						<tr>
							<td>${dto.menu_name }</td>
						</tr>
						<tr>
							<td>${dto.menu_price }</td>
						</tr>
					</table>
				</c:forEach>
			</div>
		</div>
	</div>
	<c:if test="True">
		<div class="admin_bar">
			<div class="admin_bar_list">
				<div class="bar_btn" id="menuWriteForm">신규 등록</div>
			</div>
		</div>
	</c:if>
	<footer>
		<div id="footer_content">
			<div id="footer_head">
				<p>인재채용 | 협력업체등록 | 공지사항 | 고객 센터 | 개인정보처리방침 | 이용약관</p>
			</div>
			<br><br>
			<hr style="border: 1px solid dimgray;">
			<div id="footer_foot">
				<p>대표이사 홍길동 | 사업자등록번호 123-12-12345 | 서울 서초구 서초대로 77길 55,에이프로 스퀘어 3층(서초동) | T.02-1234-1234 | F.02-9876-9876</p>
				<p>E.doosot@naver.com | 두솥 도시락 고객센터 02-2345-2345 | 전국창업설명회 02-3456-3456 | 단체주문 4567-4567</p>
				<br>
				<p>COPYRIGHT (주)두솥.ALL RIGHT RESEVED</p>
			</div>
		</div>
	</footer>
</body>
</html>