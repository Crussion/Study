<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한솥</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<style type="text/css">	
.filter{
	padding-top: 65px;
	padding-right: 55px;
	float: right;
}

.filter select{
	width: 150px;
	height: 40px;
	font-size: 16px;
}

.filter:after{
	clear: both;
}

.content{
	display: flex;
	width: 1200px;
	margin: 0 auto;
	background-color: #ececec;
}

#con{
	width: 950px;
	display: inline-flex;
	flex-direction: column;
}

#con span{
	font-size: 25px;
	font-weight: 550;
	margin-top: 30px;
	margin-left: 30px;
}

#menu_table{
	margin-top: 30px;
	margin-right: 5px;
	width: 950px;
	padding: 40px auto;
	border-spacing: 30px;
	border-collapse: separate;
}

#menu_table td{
	width: 150px;
	height: 140px;
	border: 1px solid black;
}

#food td{
	height: 20px;
}

#food th{
	height: 90px;
	text-align: left;
	border: 1px solid black;
}

#nav {
	font-size: 18px;
	display: inline-flex;
	flex-direction: column;
}

#tags{
	display: inline-flex;
	flex-direction: column;
	justify-content: space-evenly;
	text-align: center;
	width: 200px;
	height: 300px;
	margin-top: 20px;
	margin-left: 40px;
	background-color: white;
}

#new_menu{
	width: 200px;
	height: 150px;
	margin-top: 30px;
	margin-left: 40px;
	margin-bottom: 30px;
	display: inline-block;
}

#new_menu img{
	width: 100%;
	height: 100%;
}

.outline{
	width: 1200px;
	height: 350px;
	margin: 30px auto;
}

.outline hr{ 
	display: inline-block;
	width: 1050px;
	border: 8px solid black;
}

#outlink{
	margin-top: 80px;
	display: flex;
	justify-content: space-evenly;
}

#outlink div{
	width: 200px;
	height: 180px;
	border: 1px solid black;
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
		<div id="nav">
			<div id="tags">
				<span><a href="#">메뉴 보기</a></span>
				<hr width="130" color="#ececec">
				<span><a href="#">문의 하기</a></span>
				<c:if test="True">
					<hr width="130" color="#ececec">
					<span><a href="#">신규 등록</a></span>
				</c:if>
			</div>
			<div id="new_menu">
				<img alt="신메뉴" src="../image/new.jpg" >
			</div>
		</div>
		<div id="con">
			<span>전체</span>
			<table id="menu_table">
				<c:forEach begin="0" end="2" step="1">
				<tr>
					<c:forEach begin="0" end="2" step="1">
						<td>
							<table id="food">
								<tr>
									<th colspan="2">이미지</th>
								</tr>
								<tr>
									<td>음식이름</td>
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