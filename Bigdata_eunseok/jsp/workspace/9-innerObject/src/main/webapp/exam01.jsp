<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="exam01Pro.jsp" method="post">
		<h1>학번, 이름, 학년, 선택과목을 입력하는 폼</h1>
		<p>학번:<input type="text" name="num"></p>
		<p>이름:<input type="text" name="name"></p>
		<p>
			학년:
			<input type="radio" name="grade" value="1">1학년
			<input type="radio" name="grade" value="2">2학년
			<input type="radio" name="grade" value="3">3학년
			<input type="radio" name="grade" value="4">4학년
		</p>
		<p>
			선택과목:
			<select name="subject">
				<option value="JAVA">JAVA</option>
				<option value="HTML">HTML</option>
				<option value="JSP">JSP</option>
			</select>
		</p>
		<input type="submit" value="입력 완료">
	</form>
</body>
</html>