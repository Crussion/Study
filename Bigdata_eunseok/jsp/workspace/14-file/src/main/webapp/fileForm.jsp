<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th width="50">제목</th>
				<td><input type="text" name="subject" size="48"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="15" cols="50"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="upload1"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="upload2"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="파일 업로드">
					<input type="reset" value="다시 작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>