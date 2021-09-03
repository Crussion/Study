<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	BoardDTO dto = (BoardDTO) request.getAttribute("dto"); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="3"><font size="5"><%=dto.getSubject()%></font></td>
		</tr>
		<tr align="center">
			<td width="130">글번호 : <%=dto.getSeq()%></td>
			<td width="130">작성자 : <%=dto.getName()%></td>
			<td width="130">조회수 : <%=dto.getHit()%></td>
		</tr>
		<tr>
			<td colspan="3" height="300" valign="top">
				<pre><%=dto.getContent() %></pre>
			</td>
		</tr>
	</table>
	
	<input type="button" value="목록"
		onclick="location.href='boardList.do?pg=<%=pg%>'">
<% if(session.getAttribute("memId").equals(dto.getId())) { %>		
	<input type="button" value="글수정"
		onclick="location.href='#'">
	<input type="button" value="글삭제"
		onclick="location.href='boardDelete.do?seq=<%=seq%>&pg=<%=pg%>'">
<% } %>		
</body>
</html>