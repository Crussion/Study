<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "고길동";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp 파일 자체를 포함한다. -->
	<h3>** include 지시자 **</h3>
	<%@ include file="today.jsp" %>
	<!-- 번역된 html 문서를 포함한다. -->
	<h3>** jsp include **</h3>
	<jsp:include page="image.jsp"/>
	
	<div>exam01.jsp, name = <%=name %></div>
</body>
</html>