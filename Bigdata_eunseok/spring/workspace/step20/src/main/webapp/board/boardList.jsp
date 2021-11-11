<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url: "boardListJson.do",
			type: "post",
			data: { "pg": "${pg }" },
			dataType: "json",
			success: function(json){
				$.each(json.items, function(index, item){
					var tr = $("<tr>", {align: "center"})
					var td1 = $("<td>").html(item.seq)
					var td2 = $("<td>").append($("<a>",{
						id: "subjectA",
						href: "#",
						click: function(){
							if(${memId == null }){
								alert("먼저 로그인 하세요")
							}else{
								location.href="boardView.do?seq=" + item.seq + "&pg=" + ${pg }
							}
						},
						text: item.subject
					}))
					var td3 = $("<td>").html(item.id)
					var td4 = $("<td>").html(item.logtime)
					var td5 = $("<td>").html(item.hit)
					
					tr.append(td1).append(td2).append(td3).append(td4).append(td5)
					$("#boardList").append(tr)
				})
			},
			error: function(xhr, textStatus, errorThrown){
				alert("[ERROR]" + xhr.status)
			}
		})
	})
</script>
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
	
		<tbody id="boardList">
			
		</tbody>
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
			<c:if test="${startPage > 3 }">
				[<a class="paging" href="boardList.do?pg=${startPage-1 }">이전</a>]
			</c:if>
			
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${pg == i }">
					[<a class="currentPaging" href="boardList.do?pg=${i }">${i }</a>]
				</c:if>
				<c:if test="${pg != i }">
					[<a class="paging" href="boardList.do?pg=${i }">${i }</a>]
				</c:if>
			</c:forEach>
			
			<c:if test="${endPage < totalP }">
				[<a class="paging" href="boardList.do?pg=${endPage+1 }">다음</a>]
			</c:if>
			</td>
		</tr>
	</table>
	<a href="boardWriteForm.do">새글쓰기</a>
</body>
</html>