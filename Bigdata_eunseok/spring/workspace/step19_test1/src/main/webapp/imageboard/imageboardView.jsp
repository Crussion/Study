<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="300">
		<tr align="center">
			<td rowspan="4"><img alt="이미지" src="../storage/${dto.image1 }" width="150"></td>
			<td>상품명</td>
			<td>${dto.imageName }</td>
		</tr>
		<tr align="center">
			<td>단가</td>
			<td>${dto.imagePrice }</td>
		</tr>
		<tr align="center">
			<td>개수</td>
			<td>${dto.imageQty }</td>
		</tr>
		<tr align="center">
			<td>합계</td>
			<td>${dto.imagePrice * dto.imageQty }</td>
		</tr>
		<tr valign="top">
			<td colspan="3" height="300"><pre>${dto.imageContent }</pre></td>
		</tr>
		<tr align="center">
			<td colspan="3">
				<input type="button" value="목록" onclick="location.href = 'imageboardList?pg=${pg}'">
				<input type="button" value="수정">
				<input type="button" value="삭제">
			</td>
		</tr>
	</table>
</body>
</html>