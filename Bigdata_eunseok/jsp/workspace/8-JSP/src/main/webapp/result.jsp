<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	double x = Double.parseDouble(request.getParameter("x"));
	double y = Double.parseDouble(request.getParameter("y"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=x %> + <%=y %> = <%=x + y %><br>
	<%=x %> - <%=y %> = <%=x - y %><br>
	<%=x %> * <%=y %> = <%=x * y %><br>
	<%=x %> / <%=y %> = <%=x / y %><br>
</body>
</html>