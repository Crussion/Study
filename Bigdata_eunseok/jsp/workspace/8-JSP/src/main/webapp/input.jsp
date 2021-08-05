<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSubmit(){
		if(!frm.x.value || isNaN(frm.x.value)){
			alert("첫 번째 실수를 입력 하세요.");
			frm.x.value = "";
			frm.x.focus();
			return false;
		}
		
		if(!frm.y.value || isNaN(frm.y.value)){
			alert("두 번째 실수를 입력 하세요.");
			frm.y.value = "";
			frm.y.focus();
			return false;
		}
	}
</script>
<style type="text/css">
th { border: 1px solid black; padding: 0 10px; }
td { border: 1px solid black }
</style>
</head>
<body>
	<form name="frm" action="result.jsp" onsubmit="return doSubmit();">
		<table style="border: 1px solid black">
			<tr>
				<th>X</th>
				<td><input type="text" name="x"></td>
			</tr>
			<tr>
				<th>Y</th>
				<td><input type="text" name="y"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="계산">
					<input type="reset" value="원래대로">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>