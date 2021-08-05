<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSubmit(){
		if(!frm.id.value){
			alert("아이디를 입력해 주세요.");
			frm.id.focus();
			return false;
		}
		
		if(!frm.pwd.value){
			alert("비밀번호를 입력해 주세요.");
			frm.pwd.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form action="exam09Pro.jsp" name="frm" onsubmit="return doSubmit();">
		<h1>회원 인증 화면</h1>
		<p>ID:<input type="text" name="id"></p>
		<p>PW:<input type="password" name="pwd"></p>
		<input type="submit" value="확인">
	</form>
</body>
</html>