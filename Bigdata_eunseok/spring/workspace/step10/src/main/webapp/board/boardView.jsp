<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	BoardDAO dao = new BoardDAO();
	dao.UpHit(seq);
	BoardDTO dto = dao.boardView(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function Back(hit){
		location.href = "boardList.jsp?pg=" + <%=pg%>;
	}
	function boardDelete(seq){
		location.href = "boardDelete.jsp?seq=" + seq + "&pg=" + <%=pg%>;
	}
	function boardModify(seq){
		location.href = "boardModifyForm.jsp?seq=" + seq + "&pg=" + <%=pg%>;
	}
</script>
</head>
<body>
	<table border="1" width="540" height="300">
		<tr height="50" align="center">
			<td><%=dto.getSeq() %></td>
			<td width="200"><%=dto.getSubject() %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getLogtime() %></td>
			<td><%=dto.getHit() %></td>
		</tr>
		<tr>
			<td colspan="5" valign="top">
				<pre><%=dto.getContent() %></pre>
			</td>
		</tr>
	</table>
	<input type="button" onclick="Back(<%=dto.getHit()%>);" value="돌아가기">
	<%if(dto.getId().equals(session.getAttribute("memId"))) {%>
		<input type="button" onclick="boardModify(<%=seq %>);" value="글수정">
		<input type="button" onclick="boardDelete(<%=seq %>);" value="글삭제">
	<%} %>
</body>
</html>