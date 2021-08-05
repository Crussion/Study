<%@page import="member.bean.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="member.dao.MemberDAO"%>
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
	MemberDAO dao = new MemberDAO();
	List<MemberDTO> list = dao.memberList(startNum, endNum);
	
	//페이징 작업
	int total_content = dao.getTotalMember();
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
</head>
<body>
	<table border="1" width="690">
		<tr bgcolor="yellow">
			<th width="100">이름</th>
			<th>아이디</th>
			<th width="50">성별</th>
			<th width="150">이메일</th>
			<th width="140">전화번호</th>
			<th width="150">가입일</th>
		</tr>
		<!-- 확장 for문 foreach와 비슷한 느낌 -->
		<%for(MemberDTO dto : list) {%>
			<tr>
				<td><%=dto.getName() %></td>
				<td><%=dto.getId() %></td>
				<td><%=dto.getGender() %></td>
				<td><%=dto.getEmail1() %> @ <%=dto.getEmail2() %></td>
				<td><%=dto.getTel1() %> - <%=dto.getTel2() %> - <%=dto.getTel3() %></td>
				<td><%=dto.getLogtime() %>
			</tr>
		<%} %>
		<tr>
			<td colspan="6" align="center">
			<%if(startPage > 3){ %>
				[<a class="paging" href="memberList.jsp?pg=<%=startPage-1%>">이전</a>]
			<%} %>
			<%for(int i = startPage; i <= endPage; i++) {%>
				<%if(pg==i){ %>
					[<a class="currentPaging" href="memberList.jsp?pg=<%=i%>"><%=i %></a>]
				<%} else {%>
					[<a class="paging" href="memberList.jsp?pg=<%=i%>"><%=i %></a>]
				<%} %>
			<%} %>
			<%if(endPage < total_page){ %>
				[<a class="paging" href="memberList.jsp?pg=<%=endPage+1%>">다음</a>]
			<%} %>
			</td>
		</tr>
	</table>
	<a href="../main/index.jsp">메인 화면</a><br>
</body>
</html>