<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/memberScript.js"></script>
<style type="text/css">
.col {text-align: center}
</style>
</head>
<body>
	<form action="../member/login.jsp" method="post" name="login_frm">
		<table border="1">
			<tr>
				<td class="col">아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td class="col">비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td class="col" colspan="2">
					<input type="button" value="로그인" onclick="return login();">
					<input type="button" value="회원가입" onclick="location.href='../main/index.jsp?req=writeForm'">
				</td>
			</tr>
		</table>
	</form>
	<a href="../main/index.jsp">메인 화면</a>
</body>
</html>