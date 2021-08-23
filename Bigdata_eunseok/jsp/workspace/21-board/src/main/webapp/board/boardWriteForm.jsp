<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="boardWrite.do" method="post" enctype="multipart/form-data">
		<table width="550" height="500">
			<tr>
				<td colspan="2" align="center" width="100">
					<h2>게시판글등록</h2>
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
				<td bgcolor="orange">파일 첨부</td>
				<td bgcolor="skyblue"><input type="file" name="board_file"></td>
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