<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO dao = new BoardDAO();
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	int result = dao.boardDelete(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=result > 0%>){
		alert("글을 삭제하였습니다.");
	}else{
		alert("글을 삭제하는데 실패하였습니다.");
	}
	location.href = "../main/index.jsp?req=boardList&pg=" + <%=pg%>;
</script>
</head>
<body>

</body>
</html>