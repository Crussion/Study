<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));
	int seq = Integer.parseInt(request.getParameter("seq"));
	ImageboardDAO dao = new ImageboardDAO();
	ImageboardDTO dto = dao.imageView(seq);
	
	request.setAttribute("dto", dto);
	request.setAttribute("pg", pg);
	request.setAttribute("seq", seq);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardModifyForm");
	dispatcher.forward(request, response);
%>