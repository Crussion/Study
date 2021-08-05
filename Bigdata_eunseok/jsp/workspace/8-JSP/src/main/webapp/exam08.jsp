<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSubmit(){
		if(!frm.num1.value || isNaN(frm.num1.value)){
			alert("첫 번째 숫자를 입력해 주세요.");
			frm.num1.value = "";
			frm.num1.focus();
			return false;
		}
		
		if(!frm.num2.value || isNaN(frm.num2.value)){
			alert("두 번째 숫자를 입력해 주세요.");
			frm.num2.value = "";
			frm.num2.focus();
			return false;
		}
		
		if(confirm("계산 하시겠습니까?")){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<form action="exam08Pro.jsp" onsubmit="return doSubmit();" name="frm">
		<input type="text" name="num1">
		<select name="generator">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
			<option value="%">%</option>
		</select>
		<input type="text" name="num2">
		<input type="submit" value="계산">
	</form>
</body>
</html>