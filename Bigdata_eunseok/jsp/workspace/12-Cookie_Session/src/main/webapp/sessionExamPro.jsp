<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	session.setAttribute("id", id);
	session.setAttribute("pwd", pwd);
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 속성 설정 및 사용</h3>
	<p>id와 pwd를 세션에 저장하였습니다.</p>
	<P>세션에 저장된 값 확인</P>
	id = <%=session.getAttribute("id") %>,
	pwd = <%=session.getAttribute("pwd") %>
</body>
</html>