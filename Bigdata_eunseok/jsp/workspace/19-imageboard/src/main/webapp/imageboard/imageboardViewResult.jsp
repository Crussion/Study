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
	<table border="1" width="300" height="300">
		<tr>
			<td rowspan="4">
				<img src="../storage/${dto.image1 }" height="100">
			</td>
			<td>
				상품명: ${dto.imageId }
			</td>
		</tr>
		<tr>
			<td>단가: ${dto.imagePrice }
		</tr>
		<tr>
			<td>개 수: ${dto.imageQty }
		</tr>
		<tr>
			<td>단가: ${dto.imagePrice * dto.imageQty }
		</tr>
		<tr>
			<td colspan="2" height="200" valign="top">
				${dto.imageContent }
			</td>
		</tr>
	</table>
	<input type="button" value="목록" 
		onclick="location.href = '../imageboard/imageboardList.jsp?pg=${pg }'">
	<input type="button" value="삭제"
		onclick="location.href = '../imageboard/imageboardDelete.jsp?seq=${dto.seq }&pg=${pg }'">
	<input type="button" value="수정"
		onclick="location.href = '../imageboard/imageboardModifyFormReady.jsp?seq=${dto.seq }&pg=${pg }'">
</body>
</html>