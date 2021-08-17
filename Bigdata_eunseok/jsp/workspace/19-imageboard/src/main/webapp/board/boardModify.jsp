<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	int seq = Integer.parseInt(session.getAttribute("modify_seq").toString());
	int pg = Integer.parseInt(session.getAttribute("modify_pg").toString());
	
	request.setCharacterEncoding("utf-8");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	BoardDAO dao = new BoardDAO();
	int result = dao.boardModify(seq, subject, content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=result > 0%>){
		alert("글을 수정했습니다.");
		location.href = "../main/index.jsp?req=boardView&seq=" + <%=seq%> + "&pg=" + <%=pg%>;
	}else{
		alert("글을 수정하는데 실패했습니다.");
		location.href = "../main/index.jsp?req=boardView&seq=" + <%=seq%> + "&pg=" + <%=pg%>;
	}
</script>
</head>
<body>

</body>
</html>