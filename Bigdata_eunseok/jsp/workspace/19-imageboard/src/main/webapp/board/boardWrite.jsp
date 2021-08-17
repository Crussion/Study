<%@page import="boardbean.BoardDTO"%>
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
	BoardDTO dto = new BoardDTO(id, name, subject, content);
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
		location.href="../main/index.jsp?req=boardList&pg=1";
	}
</script>
</head>
<body>
<%--
	<%if(result>0){ %>
		작성하신 글을 저장하였습니다.<br>
		아이디 : <%=id %><br>
		글쓴이 : <%=name %><br>
		제목 : <%=subject %><br>
		내용 : <%=content %><br>
	<%} else {%>
		작성하신 글을 저장하는데 실패하였습니다.<br>
	<%} %>
	<a href="../main/index.jsp">메인 화면</a>
 --%>
</body>
</html>