<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSubmit(){
		if(!modify_frm.pwd.value){
			alert("비밀번호를 입력하세요")
			modify_frm.pwd.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
<div align="center">
	<form method="post" name="modify_frm" action="boardModifyPro.do?pg=${pg }&board_num=${board_num }">
		<table width="300">
			<tr>
				<th colspan="2"><h2>게시판 글 수정</h2></th>
			</tr>
			<tr>
				<td>제목 : ${bean.board_subject }</td>
				<td align="right">첨부파일 : ${bean.board_file }</td>
			</tr>
			<tr>
				<td colspan="2">
					비밀번호 : <input type="password" name="pwd">
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top" align="center" height="300" bgcolor="orange">
					<textarea rows="20" cols="30" name="modify_content">${bean.board_content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="return doSubmit();">
					<input type="button" value="뒤로" onclick="history.back();">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>