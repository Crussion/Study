<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.flex{
	height:30px;
}
.main_top_list{
	margin:0 auto;
	width:1170px;
	height:90px;
	border:1px solid black;
	
}
ul li{
	list-style-type: none;
	float: left;
	margin-left:40px;
}
.main_photo{
	margin:0 auto;
	height:650px;
	background:yellow;
}
.menu_img{
	margin:0 auto;
	width:1170px;
	height:600px;
	background:white;
}
.menu_img1{
	float:left;
	width:570px;
	height:518px;
	background:blue;
}
.menu_img2{
	float:right;
	width:570px;
	height:518px;
	background:red;
}
.brand_img{
	margin:0 auto;
	width:1170px;
	height:450px;
	background:green;
}
footer{
	background:orange;
	height:310px;
}
</style>
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
	<div id="container">
		<div class="menu_img">
			<div class="menu_img1"></div>
			<div class="menu_img2"></div>
		</div>
		<div class="brand_img"></div>
	</div>
	<footer>
	
	</footer>
</body>
</html>