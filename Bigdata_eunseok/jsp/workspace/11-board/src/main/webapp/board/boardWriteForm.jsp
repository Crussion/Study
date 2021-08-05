<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js?ver=new"></script>
</head>
<body>
	<form name="board_frm" action="boardWrite.jsp" method="post" onsubmit="return boardSubmit();">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" size="43"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td width="300" height="150">
					<textarea rows="15" cols="45" name="content"></textarea>
					<!--<input type="text" name="content" size="40">-->
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>