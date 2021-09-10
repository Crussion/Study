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
			alert("작성하신 글을 저장하였습니다. \n 파일 이름 : ${dto.image1}");
			location.href = "imageboardList";
		}else{
			alert("작성하신 글을 저장 실패했습니다.");
			history.back();
		}
	}
</script>
</head>
<body>
</body>
</html>