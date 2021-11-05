<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/menuModify.css?v=1">
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
			<span class="title">메뉴 수정</span>
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
					<td id="category">
						<label for="ingre">난류(계란)</label>
						<input type="checkbox" name="ingre" value="난류(계란)">
						
						<label for="ingre">우유</label>
						<input type="checkbox" name="ingre" value="우유">
						
						<label for="ingre">메밀</label>
						<input type="checkbox" name="ingre" value="메밀">
						
						<label for="ingre">땅콩</label>
						<input type="checkbox" name="ingre" value="땅콩">
						
						<label for="ingre">대두</label>
						<input type="checkbox" name="ingre" value="대두">
						
						<label for="ingre">밀</label>
						<input type="checkbox" name="ingre" value="밀">
						
						<label for="ingre">고등어</label>
						<input type="checkbox" name="ingre" value="고등어">
						
						<label for="ingre">게</label>
						<input type="checkbox" name="ingre" value="게">
						
						<label for="ingre">돼지고기</label>
						<input type="checkbox" name="ingre" value="돼지고기">
						
						<br>
						
						<label for="ingre">복숭아</label>
						<input type="checkbox" name="ingre" value="복숭아">
						
						<label for="ingre">토마토</label>
						<input type="checkbox" name="ingre" value="토마토">
						
						<label for="ingre">새우</label>
						<input type="checkbox" name="ingre" value="새우">
						
						<label for="ingre">아황산류</label>
						<input type="checkbox" name="ingre" value="아황산류">
						
						<label for="ingre">호두</label>
						<input type="checkbox" name="ingre" value="호두">
						
						<label for="ingre">닭고기</label>
						<input type="checkbox" name="ingre" value="닭고기">
						
						<label for="ingre">쇠고기</label>
						<input type="checkbox" name="ingre" value="쇠고기">
						
						<label for="ingre">오징어</label>
						<input type="checkbox" name="ingre" value="오징어">
						
						<label for="ingre">조개류</label>
						<input type="checkbox" name="ingre" value="조개류">
					</td>
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
					<td colspan="2" align="center">
						<input type="submit" value="등록" class="btn">
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