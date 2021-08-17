<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function doDelete(){
	if(!delete_frm.pwd.value){
		alert("패스워드를 입력하세요");
		delete_frm.pwd.focus();
		return false;
	}
	
	delete_frm.submit();
	return true;
}

function doBack(){
	history.back();
	
	return true;
}
</script>
</head>
<body>
	<form method="post" action="../boardDelete.do?pg=${param.pg }&board_num=${param.board_num }" name="delete_frm">
		<div id="box" align="center">
			<p>글 비밀번호: <input type="password" name="pwd"></p>
			<input type="button" value="삭제" onclick="return doDelete();">
			<input type="button" value="돌아가기" onclick="return doBack();">
		</div>
	</form>
</body>
</html>