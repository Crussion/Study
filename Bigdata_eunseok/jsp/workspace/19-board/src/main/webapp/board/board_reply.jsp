<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 답글 등록</h2>
	<form action="boardReplyPro.do" method="post" name="reply_frm">
		<input type="hidden" name="pg" value=${pg }>
		<input type="hidden" name="board_num" value="${bean.board_num }">
		<input type="hidden" name="board_re_ref" value="${bean.board_re_ref }">
		<input type="hidden" name="board_re_lev" value="${bean.board_re_lev }">
		<input type="hidden" name="board_re_seq" value="${bean.board_re_seq }">
		<table width="550" height="500">
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
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>