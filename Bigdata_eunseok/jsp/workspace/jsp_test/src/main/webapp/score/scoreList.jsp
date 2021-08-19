<%@page import="java.util.List"%>
<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	ScoreDAO dao = new ScoreDAO();
	if(request.getParameter("num") != null){
		ScoreBean bean = new ScoreBean();
		bean.setStudent_num(Integer.parseInt(request.getParameter("num")));
		bean.setStudent_name(request.getParameter("name"));
		if(!request.getParameter("score_kor").equals(""))
			bean.setScore_kor(Double.parseDouble(request.getParameter("score_kor")));
		else
			bean.setScore_kor(0);
		if(!request.getParameter("score_eng").equals(""))
			bean.setScore_eng(Double.parseDouble(request.getParameter("score_eng")));
		else
			bean.setScore_eng(0);
		if(!request.getParameter("score_math").equals(""))
			bean.setScore_math(Double.parseDouble(request.getParameter("score_math")));
		else
			bean.setScore_math(0);
		int result = dao.scoreWrite(bean);
		if(result > 0){
			System.out.println("저장 완료");
		}else{
			System.out.println("저장 실패");
		}
	}
	
	int pg = 1;
	if(request.getParameter("pg") != null)
		pg = Integer.parseInt(request.getParameter("pg"));
	
	int endNum = pg * 10;
	int startNum = endNum - 9;
	
	List<ScoreBean> list = dao.scoreList(startNum, endNum);

	int total_content = dao.getTotal();
	int total_page = (total_content + 9) / 10;
	
	int startPage = (pg - 1) / 3 * 3 + 1;
	int endPage = startPage + 2;
	if(endPage>total_page) endPage = total_page;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 목록</title>
<style type="text/css">
.paging { color: blue; text-decoration: none; }
.currentPaging { color: red; text-decoration: underline; }
</style>
</head>
<body>
<c:set var="list" value="<%=list %>"/>
<c:set var="pg" value="<%=pg %>"/>
<c:set var="startPage" value="<%=startPage %>"/>
<c:set var="endPage" value="<%=endPage %>"/>
<c:set var="total_page" value="<%=total_page %>"/>
	<table border="1">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<c:forEach var="bean" items="${list }">
			<tr>
				<td width="100">${bean.student_num }</td>
				<td width="100">${bean.student_name }</td>
				<td width="60"><fmt:formatNumber value="${bean.score_kor }" pattern=".0"/></td>
				<td width="60"><fmt:formatNumber value="${bean.score_eng }" pattern=".0"/></td>
				<td width="60"><fmt:formatNumber value="${bean.score_math }" pattern=".0"/></td>
				<td width="80"><fmt:formatNumber value="${bean.score_total }" pattern=".0"/></td>
				<td width="80"><fmt:formatNumber value="${bean.score_avg }" pattern=".0"/></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center">
			<c:if test="${startPage > 3 }">
				[<a class="paging" href="scoreList.jsp?pg=${startPage-1 }">이전</a>]
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${pg==i }">
					[<a class="currentPaging" href="scoreList.jsp?pg=${i }">${i }</a>]
				</c:if>
				<c:if test="${pg!=i }">
					[<a class="paging" href="scoreList.jsp?pg=${i }">${i }</a>]
				</c:if>
			</c:forEach>
			<c:if test="${endPage < total_page }">
				[<a class="paging" href="scoreList.jsp?pg=${endPage+1 }">다음</a>]
			</c:if>
			</td>
		</tr>
	</table>
	<a href="../index.jsp">메인화면</a>
</body>
</html>