<%@page import="board.dao.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="boardbean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	/*
	pg=1 : startNum = 1, endNum = 5
	pg=2 : startNum = 6, endNum = 10
	pg=n : startnum = endNum - 4, endNum = 5 * pg
	*/
	int endNum = pg * 5;
	int startNum = endNum - 4;
	BoardDAO dao = new BoardDAO();
	List<BoardDTO> list = dao.boardList(startNum, endNum);
	
	//페이징 작업
	int total_content = dao.getTotal();
	int total_page = (total_content + 4) / 5;
	
	// 3페이지가 한블럭으로 표시
	//     1 2 3 다음
	// 이전 4 5 6 다음
	// 이전 7 8 
	int startPage = (pg - 1) / 3 * 3 + 1;
	int endPage = startPage + 2;
	if(endPage>total_page) endPage = total_page;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isLogin(seq){
		<% if(session.getAttribute("memId") == null){%>
			alert("먼저 로그인 하세요");
			location.href = "../main/index.jsp?req=loginForm";
		<%} else {%>
			location.href = "../main/index.jsp?req=boardView&seq=" + seq + "&pg=" + <%=pg%>;
		<%}%>
	}
</script>
<style type="text/css">
#subjectA:link {
	color:black; text-decoration: none;
}
#subjectA:visited {
	color:black; text-decoration: none;
}
#subjectA:hover {
	color:green; text-decoration: underline;;
}
#subjectA:active {
	color:black; text-decoration: none;
}

.paging { color: blue; text-decoration: none; }
.currentPaging { color: red; text-decoration: underline; }
</style>
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
		<%for(BoardDTO dto : list) {%>
			<tr>
				<td><%=dto.getSeq() %></td>
				<td>
					<a id="subjectA" href="#" onclick="isLogin(<%=dto.getSeq()%>)">
						<%=dto.getSubject() %>
					</a>
				</td>
				<td><%=dto.getId() %></td>
				<td><%=dto.getLogtime() %></td>
				<td><%=dto.getHit() %></td>
			</tr>
		<%} %>
		<tr>
			<td colspan="5" align="center">
			<%if(startPage > 3){ %>
				[<a class="paging" href="../main/index.jsp?req=boardList&pg=<%=startPage-1%>">이전</a>]
			<%} %>
			<%for(int i = startPage; i <= endPage; i++) {%>
				<%if(pg==i){ %>
					[<a class="currentPaging" href="../main/index.jsp?req=boardList&pg=<%=i%>"><%=i %></a>]
				<%} else {%>
					[<a class="paging" href="../main/index.jsp?req=boardList&pg=<%=i%>"><%=i %></a>]
				<%} %>
			<%} %>
			<%if(endPage < total_page){ %>
				[<a class="paging" href="../main/index.jsp?req=boardList&pg=<%=endPage+1%>">다음</a>]
			<%} %>
			</td>
		</tr>
	</table>
	<%if(session.getAttribute("memId") == null){ %>
		<a href="../main/index.jsp?req=loginForm">로그인</a><br>
	<%} else {%>
		<a href="../main/index.jsp?req=boardWriteForm">글쓰기</a><br>
	<%} %>
	<a href="../main/index.jsp">메인 화면</a><br>
</body>
</html>

<%-- 일반 for 문
<%for(int i = 0; i < list.size(); i++) {%>
	<tr>
		<td><%=list.get(i).getSeq() %></td>
		<td><%=list.get(i).getSubject() %></td>
		<td><%=list.get(i).getId() %></td>
		<td><%=list.get(i).getLogtime() %></td>
		<td><%=list.get(i).getHit() %></td>
	</tr>
<%} %>
 --%>