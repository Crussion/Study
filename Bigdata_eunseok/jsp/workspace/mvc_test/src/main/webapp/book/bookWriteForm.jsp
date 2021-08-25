<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/bookScript.js?v=n"></script>
</head>
<body>
	<form action="bookWrite.do" method="post" name="frm" onsubmit="return doSubmit();">
		<table border="1">
			<tr>
				<th>도서코드</th>
				<td><input type="number" name="book_num"></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><input type="text" name="book_subject"></td>
			</tr>
			<tr>
				<th>저자</th>
				<td><input type="text" name="book_writer"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input type="text" name="book_publisher"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="number" name="book_price"></td>
			</tr>
			<tr>
				<th>출판일</th>
				<td>
					<input type="number" name="book_date1"> -
					<input type="number" name="book_date2"> -
					<input type="number" name="book_date3">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="도서입력">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>