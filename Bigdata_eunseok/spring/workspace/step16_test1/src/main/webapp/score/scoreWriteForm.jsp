<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/scoreScript.js"></script>
</head>
<body>
	<form action="scoreWrite.do" method="post" name="frm" onsubmit="return doSubmit();">
		<table>
			<tr>
				<td bgcolor="orange">학번</td>
				<td><input type="text" name="studNo"></td>
			</tr>
			<tr>
				<td bgcolor="orange">이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td bgcolor="orange">국어</td>
				<td><input type="number" name="kor"></td>
			</tr>
			<tr>
				<td bgcolor="orange">수학</td>
				<td><input type="number" name="eng"></td>
			</tr>
			<tr>
				<td bgcolor="orange">영어</td>
				<td><input type="number" name="mat"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>