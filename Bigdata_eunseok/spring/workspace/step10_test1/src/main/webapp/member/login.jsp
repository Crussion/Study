<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	MemberDAO dao = new MemberDAO();
	String name = dao.login(id, pwd);
	
	if(name != null){
		session.setAttribute("memId", id);
		session.setAttribute("memName", name);
		response.sendRedirect("../board/boardList.jsp?pg=1");
	}else{
		response.sendRedirect("loginForm.jsp");
	}
%>