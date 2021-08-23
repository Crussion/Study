<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSubmit(){
		if(!frm.board_name.value){
			alert("작성자를 입력해 주세요");
			frm.board_name.focus();
			return false;
		}
		
		if(!frm.board_pwd.value){
			alert("비밀번호를 입력하세요");
			frm.board_pwd.focus();
			return false;
		}
		
		if(!frm.board_subject.value){
			alert("글 제목을 입력하세요");
			frm.board_subject.focus();
			return false;
		}
		
		if(!frm.board_content.value){
			alert("글 내용을 입력해 주세요");
			frm.board_content.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<form action="boardReply.do?pg=${pg }&board_num=${bean.board_num }" method="post" name="frm" onsubmit="return doSubmit();">
		<table width="550" height="500">
			<tr>
				<td colspan="2" align="center" width="100">
					<h2>답변글등록</h2>
				</td>
			</tr>
			<tr>
				<td bgcolor="orange">글쓴이</td>
				<td bgcolor="skyblue"><input type="text" name="board_name"></td>
			</tr>
			<tr>
				<td bgcolor="orange">비밀번호</td>
				<td bgcolor="skyblue"><input type="password" name="board_pwd"></td>
			</tr>
			<tr>
				<td bgcolor="orange">제 목</td>
				<td bgcolor="skyblue"><input type="text" name="board_subject"></td>
			</tr>
			<tr>
				<td bgcolor="orange">내 용</td>
				<td bgcolor="skyblue"><textarea rows="20" cols="60" name="board_content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="button" value="돌아가기" onclick="history.back();">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>