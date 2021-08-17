<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		if(${result > 0}){
			alert("정보가 수정되었습니다.");
			location.href = "../main/index.jsp";
		}else{
			alert("정보수정이 실패하였습니다.");
			history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>