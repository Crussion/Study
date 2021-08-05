<%@page import="java.net.URLEncoder"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	MemberDAO dao = new MemberDAO();
	String name = dao.login(id, pwd);
	
	//페이지 이동
	if(name != null){
		//페이지를 이동할때 get방식으로 하면 주소창에 데이터가 표시되기에 보안에 취약하다.
		//보안에 관련된 데이터는 쿠키 또는 세션을 이용한다.
		//get방식은 문자열을 전송할때 utf-8로 전송하기 때문에 한글은 엔코딩 설정을 해줘야한다.
		//response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name, "utf-8") + "&id=" + id);
		
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		response.sendRedirect("loginOk.jsp");
	}else{
		response.sendRedirect("loginfail.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	<%if(name != null) { %>
		<%=name %>님이 로그인
	<%} else { %>
		아이디 또는 비밀번호가 틀렸으니 다시 로그인 하세요.<br>
		<a href="loginForm.jsp">로그인</a>
	<%} %>
--%>
</body>
</html>