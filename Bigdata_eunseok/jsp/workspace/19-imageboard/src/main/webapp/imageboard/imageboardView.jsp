<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int pg = 1;
	if(request.getParameter("pg") != "" || request.getParameter("pg") != null){
		pg = Integer.parseInt(request.getParameter("pg"));
	}
	
	int seq = 1;
	if(request.getParameter("seq") != "")
		seq = Integer.parseInt(request.getParameter("seq"));
	
	ImageboardDAO dao = new ImageboardDAO();
	ImageboardDTO dto = dao.imageView(seq);
	
	request.setAttribute("dto", dto);
	request.setAttribute("pg", pg);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardViewResult");
	dispatcher.forward(request, response);
%>