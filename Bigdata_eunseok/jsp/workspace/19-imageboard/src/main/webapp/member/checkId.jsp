<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");

	MemberDAO dao = new MemberDAO();
	boolean chk = dao.checkId(id);
	
	request.setAttribute("id", id);
	request.setAttribute("chk", chk);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("../member/checkIdResult.jsp");
	dispatcher.forward(request, response);
%>