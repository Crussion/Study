<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function onSubmit(){
		if(frm.name.value == ""){
			alert("이름을 입력해 주세요.");
			frm.name.focus();
			return false;
		}
		
		if(!frm.kor.value || isNaN(frm.kor.value)){
			alert("국어 점수를 입력해 주세요.");
			frm.kor.focus();
			frm.kor.value = "";
			return false;
		}
		
		if(!frm.eng.value || isNaN(frm.eng.value)){
			alert("영어 점수를 입력해 주세요.");
			frm.eng.focus();
			frm.eng.value = "";
			return false;
		}
		
		if(!frm.math.value || isNaN(frm.math.value)){
			alert("수학 점수를 입력해 주세요.");
			frm.math.focus();
			frm.math.value = "";
			return false;
		}
		
		if(confirm("데이터를 전송하시겠습니까?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<h1>이름과 성적을 입력하세요</h1>
	<form name="frm" action="exam05Pro.jsp" onsubmit="return onSubmit();">
		<p>이름 : <input type="text" name="name"></p>
		<p>국어 : <input type="text" name="kor"></p>
		<p>영어 : <input type="text" name="eng"></p>
		<p>수학 : <input type="text" name="math"></p>
		<input type="submit" value="입력 완료">
		<input type="reset" value="다시 작성">
	</form>
</body>
</html>