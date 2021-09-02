<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int pg = 1;
	if (request.getParameter("pg") != null) {
		pg = Integer.parseInt(request.getParameter("pg"));
	}
	
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	BoardDAO dao = new BoardDAO();
	List<BoardDTO> list = dao.boardList(startNum, endNum);
	
	int tot_content = dao.total_content();
	int tot_page = (tot_content + 4) / 5;
	
	int startPage = (pg - 1) / 5 * 5 + 1;
	int endPage = startPage + 4;
	if (endPage > tot_page)
		endPage = tot_page;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="540">
		<tr bgcolor="yellow">
			<th width="70">글번호</th>
			<th>제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>
		<!-- 확장 for문 foreach와 비슷한 느낌 -->
		<%for (BoardDTO dto : list) {%>
			<tr>
				<td><%=dto.getSeq()%></td>
				<td><a href="boardView.jsp?pg=<%=pg %>&seq=<%=dto.getSeq() %>"> <%=dto.getSubject()%></a></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getLogtime()%></td>
				<td><%=dto.getHit()%></td>
			</tr>
		<%}%>
		<tr>
			<td colspan="5" align="center">
				<%if (startPage > 3) {%>
					[<a href="boardList.jsp?pg=<%=startPage - 1%>">이전</a>]
				<%}%> 
				<%for (int i = startPage; i <= endPage; i++) {%>
					[<a href="boardList.jsp?pg=<%=i%>"><%=i%></a>]
				<%}%>
				<%if (endPage < tot_page) {%>
					[<a class="paging"
					href="boardList.jsp?pg=<%=endPage + 1%>">다음</a>]
				<%}%>
			</td>
		</tr>
	</table>
	<%if(session.getAttribute("memId") == null){ %>
		<a href="../member/loginForm.jsp">로그인</a><br>
	<%} else {%>
		<a href="boardWriteForm.jsp">글쓰기</a><br>
	<%} %>
	<a href="../main/index.jsp">메인 화면</a><br>
</body>
</html>