<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = session.getAttribute("memName").toString();
	String id = session.getAttribute("memId").toString();
	
	//String name = request.getParameter("name");
	//String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img alt="" src="../image/tumi.png" width="30" onclick="location.href='../main/index.jsp'"
		style="cursor:pointer">
	<%=id + "(" + name + ")" %>님이 로그인
</body>
</html>