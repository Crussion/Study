<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css?v=1">
<link rel="stylesheet" type="text/css" href="../css/menuList.css?v=1">
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
			<span class="title">두솥 메뉴</span>
			<span class="filter">
				<select>
					<option value="total">전체</option>
					<option value="gogigogi">고기고기</option>
					<option value="mayo">마요</option>
				</select>
			</span>
		</div>
	</div>
	<div class="content">
		<div id="con">
			<span>전체</span>
			<table id="menu_table">
				<c:forEach begin="0" end="0" step="1">
				<tr>
					<c:forEach begin="0" end="2" step="1">
						<td>
							<table id="food" onclick="location.href='#'">
								<tr>
									<td id="img">이미지</td>
								</tr>
								<tr>
									<td>음식이름</td>
								</tr>
								<tr>
									<td>가격</td>
								</tr>
							</table>
						</td>
					</c:forEach>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<c:if test="True">
		<div class="admin_bar">
			<div class="admin_bar_list">
				<div class="bar_btn" onclick="">신규 등록</div>
			</div>
		</div>
	</c:if>
	<div class="outline">
		<span>더 많은 이야기</span> <hr>
		<div id="outlink">
			<div id="store">지점포</div>
			<div id="event">이벤트</div>
			<div id="pranchise">프랜차이즈</div>
		</div>
	</div>
	<footer>
	
	</footer>
</body>
</html>