<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/menuWriteForm.css">
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
					<li class="mtl"><a href="#">MENU</a></li>
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
			<span class="title">메뉴 등록</span>
		</div>
	</div>
	<div class="content">
		<form action="menuWrite.do" id="frm" name="menu_frm" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td width="120"><span class="need">*</span><span>상품 번호</span></td>
					<td><input type="text" class="input" name="menu_num"></td>
				</tr>
				<tr>
					<td><span class="need">*</span><span>상품 종류</span></td>
					<td><select class="input" name="menu_category">
						<option>-----선택하세요-----</option>
						<option value="고기고기">고기고기</option>
						<option value="마요">마요</option>
					</select></td>
				</tr>
				<tr>
					<td><span class="need">*</span><span>상품 이름</span></td>
					<td><input type="text" class="input" name="menu_name"></td>
				</tr>
				<tr>
					<td><span class="need">*</span><span>상품 가격</span></td>
					<td><input type="number" class="input" name="menu_price"></td>
				</tr>
				<tr>
					<td><span class="need">*</span><span>상품 칼로리</span></td>
					<td><input type="number" placeholder="Kcal" class="input" name="menu_kcal"></td>
				</tr>
				<tr>
					<td><span>상품 설명</span></td>
					<td><textarea class="input" name="menu_content"></textarea></td>
				</tr>
				<tr>
					<td><span class="need">*</span><span>상품 재료</span></td>
					<td id="category">
						<label for="menu_ingre">난류(계란)</label>
						<input type="checkbox" name="menu_ingre" value="난류(계란)" class="checkbox">
						
						<label for="menu_ingre">우유</label>
						<input type="checkbox" name="menu_ingre" value="우유" class="checkbox">
						
						<label for="menu_ingre">메밀</label>
						<input type="checkbox" name="menu_ingre" value="메밀" class="checkbox">
						
						<label for="menu_ingre">땅콩</label>
						<input type="checkbox" name="menu_ingre" value="땅콩" class="checkbox">
						
						<label for="menu_ingre">대두</label>
						<input type="checkbox" name="menu_ingre" value="대두" class="checkbox">
						
						<label for="menu_ingre">밀</label>
						<input type="checkbox" name="menu_ingre" value="밀" class="checkbox">
						
						<label for="menu_ingre">고등어</label>
						<input type="checkbox" name="menu_ingre" value="고등어" class="checkbox">
						
						<label for="menu_ingre">게</label>
						<input type="checkbox" name="menu_ingre" value="게" class="checkbox">
						
						<label for="menu_ingre">돼지고기</label>
						<input type="checkbox" name="menu_ingre" value="돼지고기" class="checkbox">
						
						<br>
						
						<label for="menu_ingre">복숭아</label>
						<input type="checkbox" name="menu_ingre" value="복숭아" class="checkbox">
						
						<label for="menu_ingre">토마토</label>
						<input type="checkbox" name="menu_ingre" value="토마토" class="checkbox">
						
						<label for="menu_ingre">새우</label>
						<input type="checkbox" name="menu_ingre" value="새우" class="checkbox">
						
						<label for="menu_ingre">아황산류</label>
						<input type="checkbox" name="menu_ingre" value="아황산류" class="checkbox">
						
						<label for="menu_ingre">호두</label>
						<input type="checkbox" name="menu_ingre" value="호두" class="checkbox">
						
						<label for="menu_ingre">닭고기</label>
						<input type="checkbox" name="menu_ingre" value="닭고기" class="checkbox">
						
						<label for="menu_ingre">쇠고기</label>
						<input type="checkbox" name="menu_ingre" value="쇠고기" class="checkbox">
						
						<label for="menu_ingre">오징어</label>
						<input type="checkbox" name="menu_ingre" value="오징어" class="checkbox">
						
						<label for="menu_ingre">조개류</label>
						<input type="checkbox" name="menu_ingre" value="조개류" class="checkbox">
					</td>
				</tr>
				<tr>
					<td><span>상품 이미지</span></td>
					<td><input type="file" class="input" id="file" name="menu_img"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록" class="btn">
						<input type="reset" value="취소" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<footer>
	
	</footer>
</body>
</html>