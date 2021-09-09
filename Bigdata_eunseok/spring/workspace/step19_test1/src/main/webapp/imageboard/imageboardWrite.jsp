<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		alert("작성하신 글을 저장하였습니다. \n 파일 이름 : ${dto.image1}");
		location.href = "imageboardList";
	}
</script>
</head>
<body>
</body>
</html>