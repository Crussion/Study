<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
fwd 페이지<br>
결과 : <%=request.getAttribute("apple") %><br>
결과 : ${requestScope.apple }<br>
결과 : ${apple }<br>
</body>
</html>