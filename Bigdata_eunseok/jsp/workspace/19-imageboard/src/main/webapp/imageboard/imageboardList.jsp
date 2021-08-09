<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="java.util.List"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int pg = 1;
	if(request.getParameter("pg") != "" || request.getParameter("pg") != null){
		pg = Integer.parseInt(request.getParameter("pg"));
	}
	
	int endnum = pg * 5;
	int startnum = endnum - 4;
	
	ImageboardDAO dao = new ImageboardDAO();
	List<ImageboardDTO> list = dao.imageboardList(startnum, endnum);

	request.setAttribute("pg", pg);
	request.setAttribute("list", list);
	
	//페이징 작업
	int total_content = dao.getTotal();
	int total_page = (total_content + 4) / 5;
	
	// 3페이지가 한블럭으로 표시
	//     1 2 3 다음
	// 이전 4 5 6 다음
	// 이전 7 8 
	int startPage = (pg - 1) / 3 * 3 + 1;
	int endPage = startPage + 2;
	if (endPage>total_page) endPage = total_page;
	
	request.setAttribute("startPage", startPage);
	request.setAttribute("endPage", endPage);
	request.setAttribute("total_page", total_page);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardListResult");
	dispatcher.forward(request, response);
%>