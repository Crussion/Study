<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//double x = Double.parseDouble(request.getParameter("x"));
	//double y = Double.parseDouble(request.getParameter("y"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp 표현식 -->
	<%--
	<p><%=x %> + <%=y %> = <%=x + y %></p>
	<p><%=x %> - <%=y %> = <%=x - y %></p>
	<p><%=x %> * <%=y %> = <%=x * y %></p>
	<p><%=x %> / <%=y %> = <%=x / y %></p>
	--%>
	<hr>
	<!-- el 표현식 -->
	<p>${param.x } + ${param.y } = ${param.x + param.y }</p>
	<p>${param.x } - ${param.y } = ${param.x - param.y }</p>
	<p>${param.x } * ${param.y } = ${param.x * param.y }</p>
	<p>${param.x } / ${param.y } = ${param.x / param.y }</p>
	
</body>
</html>