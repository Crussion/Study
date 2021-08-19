<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
</head>
<script type="text/javascript">
	function doSubmit(){
		if(!frm.num.value){
			alert("학번을 입력해 주세요.");
			frm.num.focus();
			return false;
		}
		
		if(!frm.name.value){
			alert("이름을 입력해 주세요.");
			frm.name.focus();
			return false;
		}
		
		return true;
	}
</script>
<body>
	<form action="scoreList.jsp?pg=1" name="frm" onsubmit="return doSubmit();" method="get">
		<table border="1">
			<tr>
				<th>학번</th>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input type="number" name="score_kor"></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input type="number" name="score_eng"></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input type="number" name="score_math"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="저장">
					<input type="button" value="메인화면" onclick="location.href = '../index.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>