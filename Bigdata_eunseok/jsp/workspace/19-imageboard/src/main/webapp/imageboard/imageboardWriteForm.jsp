<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록</title>
<style type="text/css">
h3 {margin: 0;}
</style>
</head>
<body>
	<h3>이미지 등록</h3>
	<form action="../imageboard/imageboardWrite.jsp" method="post" enctype="multipart/form-data">
		<table border="1" width="500">
			<tr>
				<th width="100">상품코드</th>
				<td><input type="text" name="imageId" value="img_" size="50"></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="imageName" size="50"></td>
			</tr>
			<tr>
				<th>단가</th>
				<td><input type="text" name="imagePrice" size="50"></td>
			</tr>
			<tr>
				<th>개수</th>
				<td><input type="text" name="imageQty" size="50"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="53" name="imageContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="image1"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="이미지등록" onsubmit="return false;">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>