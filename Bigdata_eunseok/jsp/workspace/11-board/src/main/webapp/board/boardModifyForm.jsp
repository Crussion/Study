<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	session.setAttribute("modify_seq", seq);
	session.setAttribute("modify_pg", pg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js"></script>
</head>
<body>
	<form name="modify_frm" action="boardModify.jsp" method="post"
			onsubmit="return boardModify();">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" size="43"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td width="300" height="150">
					<textarea rows="15" cols="45" name="content"></textarea>
					<!--<input type="text" name="content" size="40">-->
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>