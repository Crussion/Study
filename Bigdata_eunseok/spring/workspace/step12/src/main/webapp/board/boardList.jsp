<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int totalP = (Integer) request.getAttribute("totalP");
	int startPage = (Integer) request.getAttribute("startPage");
	int endPage = (Integer) request.getAttribute("endPage");
	List<BoardDTO> list = (List) request.getAttribute("list");
	int pg = (Integer) request.getAttribute("pg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
#subjectA:link {color: black; text-decoration: none;}
#subjectA:visited {color: black; text-decoration: none;}
#subjectA:hover {color: green; text-decoration: underline;}
#subjectA:active {color: black; text-decoration: none;}

.paging {color: blue; text-decoration: none;}
.currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
	<table border="1" width="550" style="margin:auto;">
		<tr bgcolor="skyblue">
			<th width="70">글번호</th>
			<th>제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>
	<% for(BoardDTO dto : list) { %>
		<tr align="center">
			<td><%=dto.getSeq() %></td>
			<td><a id="subjectA" href="boardView.do?seq=<%=dto.getSeq()%>&pg=<%=pg%>">
					<%=dto.getSubject()%></a></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getLogtime() %></td>
			<td><%=dto.getHit() %></td>
		</tr>
	<% } %>	
<%--		
	<% for(int i=0; i<list.size(); i++) {
			BoardDTO dto = list.get(i); %>
		<tr align="center">
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getSubject() %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getLogtime() %></td>
			<td><%=dto.getHit() %></td>
		</tr>
	<% } %>	
 --%>	
		<!-- 페이징 -->
		<tr>
			<td colspan="5" align="center">
			<% if(startPage > 3) { %>
				[<a class="paging" href="boardList.do?pg=<%=startPage-1%>">이전</a>]
			<% } %>
				
			<% for(int i=startPage; i<=endPage; i++) { %>	
				<% if(pg==i) { %>
					[<a class="currentPaging" href="boardList.do?pg=<%=i%>"><%=i %></a>]
				<% } else { %>
					[<a class="paging" href="boardList.do?pg=<%=i%>"><%=i %></a>]
				<% } %>
			<% } %>
			
			<% if(endPage < totalP) { %>
				[<a class="paging" href="boardList.do?pg=<%=endPage+1%>">다음</a>]
			<% } %>
			</td>
		</tr>
	</table>
	<a href="boardWriteForm.do">새글쓰기</a>
</body>
</html>