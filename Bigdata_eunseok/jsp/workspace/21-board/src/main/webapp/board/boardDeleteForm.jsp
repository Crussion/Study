<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSubmit(){
		if(!frm.pwd.value){
			alert("비밀번호를 입력하세요");
			frm.pwd.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<div align="center">
		<form action="boardDelete.do?pg=${pg }&board_num=${bean.board_num }" method="post" name="frm" onsubmit="return doSubmit();">
			<p>비밀번호: <input type="password" name="pwd"></p>
			<p align="center">
				<input type="submit" value="삭제하기">
				<input type="button" value="돌아가기" onclick="history.back()">
			</p>
		</form>
	</div>
</body>
</html>