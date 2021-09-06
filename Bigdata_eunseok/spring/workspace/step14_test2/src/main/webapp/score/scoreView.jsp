<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goList(){
		location.href = 'scoreList.do?pg=' + ${pg };
	}
	function deleteView(){
		location.href = 'scoreDelete.do?studNo='+ ${dto.studNo } + '&pg=' + ${pg };
	}
</script>
</head>
<body>
	<form action="">
		<table border="1">
			<tr bgcolor="orange">
				<th colspan="6">${dto.name }</th>
			</tr>
			<tr align="center" bgcolor="#f7e6a3">
				<td width="120">학번</td>
				<td width="120">국어</td>
				<td width="120">영어</td>
				<td width="120">수학</td>
				<td width="120">총점</td>
				<td width="120">평균</td>
			</tr>
			<tr align="center" bgcolor="#f7e6a3">
				<td>${dto.studNo }</td>
				<td>${dto.kor }</td>
				<td>${dto.eng }</td>
				<td>${dto.mat }</td>
				<td>${dto.tot }</td>
				<td>${dto.avg }</td>
			</tr>
		</table>
		<input type="button" value="목록" onclick="goList()">
		<input type="button" value="성적수정">
		<input type="button" value="성적삭제" onclick="deleteView()">
	</form>
</body>
</html>