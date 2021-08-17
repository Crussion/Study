<%@page import="java.net.URLEncoder"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	MemberDAO dao = new MemberDAO();
	String name = dao.login(id, pwd);
	
	if(name != null){
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
	}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=loginResult");
	dispatcher.forward(request, response);
%>