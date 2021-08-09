<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//실제 파일 저장 폴더 위치 확인
	String realFolder = request.getServletContext().getRealPath("/storage");
	
	// 브라우저에서 보내온 문자열과 파일 데이터는 cos.jar에 있는 MultipartRequest 사용
	// new DefaultFileRenamePolicy() : 업로드시, 똑같은 파일이름이 있을 경우 기존 파일이름에 숫자를 덧붙여 저장.
	MultipartRequest multi = new MultipartRequest(request, realFolder,
									5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());

	ImageboardDTO dto = new ImageboardDTO();

	String imageId = multi.getParameter("imageId");
	String imageName = multi.getParameter("imageName");
	int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
	int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
	String imageContent = multi.getParameter("imageContent");
	//서버의 storage 폴더에 저장된 파일 이름
	String fileName = multi.getFilesystemName("image1");
	
	dto.setImageId(imageId);
	dto.setImageName(imageName);
	dto.setImagePrice(imagePrice);
	dto.setImageQty(imageQty);
	dto.setImageContent(imageContent);
	dto.setImage1(fileName);
	
	ImageboardDAO dao = new ImageboardDAO();
	int result = dao.imageboardUpload(dto);
	
	//화면 네비게이션
	//1. 공유데이터 저장
	request.setAttribute("result", result);
	request.setAttribute("imageName", imageName);
	//2. 화면이동 : forward 방식
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardWriteResult");
	dispatcher.forward(request, response);
%>