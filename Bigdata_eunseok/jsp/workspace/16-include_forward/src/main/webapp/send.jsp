<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("apple", "사과1");	// 현재 페이지
	request.setAttribute("apple", "사과2");		// 다음 페이지
	session.setAttribute("apple", "사과3");		// 같은 브라우저를 사용하는 모든 페이지
	application.setAttribute("apple", "사과4");	// 서버가 독작될 동안 프로젝트의 모든 브라우저
	
	response.sendRedirect("sendResult.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${pageScope.apple }</p>
	<p>${requestScope.apple }</p>
	<p>${sessionScope.apple }</p>
	<p>${applicationScope.apple }</p>
	<hr>
	<p><%=pageContext.getAttribute("apple") %></p>
	<p><%=request.getAttribute("apple") %></p>
	<p><%=session.getAttribute("apple") %></p>
	<p><%=application.getAttribute("apple") %></p>
</body>
</html>