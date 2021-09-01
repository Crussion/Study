<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = session.getAttribute("memId").toString();
	String name = session.getAttribute("memName").toString();
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = new BoardDTO();
	dto.setId(id);
	dto.setName(name);
	dto.setSubject(subject);
	dto.setContent(content);
	int result = dao.write(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		<%if(result>0){ %>
			alert("작성하신 글을 저장하였습니다.")
		<%} else {%>
			alert("작성하신 글을 저장하는데 실패하였습니다.")
		<%} %>
		location.href="boardList.jsp?pg=1";
	}
</script>
</head>
<body>

</body>
</html>