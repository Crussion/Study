<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이미지 수정</h3>
	<form action="../imageboard/imageboardModify.jsp?pg=${pg }&seq=${seq }" method="post" enctype="multipart/form-data">
		<table border="1" width="500">
			<tr>
				<th width="100">상품코드</th>
				<td><input type="text" name="imageId" value="${dto.imageId }" size="50"></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="imageName" size="50" value="${dto.imageName }"></td>
			</tr>
			<tr>
				<th>단가</th>
				<td><input type="text" name="imagePrice" size="50" value="${dto.imagePrice }"></td>
			</tr>
			<tr>
				<th>개수</th>
				<td><input type="text" name="imageQty" size="50" value="${dto.imageQty }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="53" name="imageContent">${dto.imageContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="image1"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="이미지수정">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>