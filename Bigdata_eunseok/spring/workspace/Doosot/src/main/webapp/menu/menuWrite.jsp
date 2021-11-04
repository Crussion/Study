<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/menuWrite.css">
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
			<span class="title">메뉴 등록</span>
		</div>
	</div>
	<div class="content">
		<form action="" id="frm">
			<table>
				<tr>
					<td width="120"><span>상품 번호</span></td>
					<td><input type="text" class="input"></td>
				</tr>
				<tr>
					<td><span>상품 이름</span></td>
					<td><input type="text" class="input"></td>
				</tr>
				<tr>
					<td><span>상품 가격</span></td>
					<td><input type="number" class="input"></td>
				</tr>
				<tr>
					<td><span>상품 칼로리</span></td>
					<td><input type="number" placeholder="Kcal" class="input"></td>
				</tr>
				<tr>
					<td><span>상품 설명</span></td>
					<td><textarea class="input"></textarea></td>
				</tr>
				<tr>
					<td><span>상품 재료</span></td>
					<td><input type="text" class="input" placeholder="ex) 우유, 치즈, 콩, 땅콩"></td>
				</tr>
				<tr>
					<td><span>상품 출시일</span></td>
					<td><input type="date" class="input"></td>
				</tr>
				<tr>
					<td><span>상품 이미지</span></td>
					<td><input type="file" class="input" id="file"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록" class="btn">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="취소" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<footer>
	
	</footer>
</body>
</html>