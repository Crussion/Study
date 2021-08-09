<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");

	MemberDAO dao = new MemberDAO();
	boolean chk = dao.checkId(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkIdClose(){
		opener.frm.id.value = "<%=id%>";
		window.close();
		opener.frm.pwd.focus();
		opener.frm.check.value = "true";
	}
</script>
</head>
<body>
	<form action="checkId.jsp" method="post" name="checkId_frm">
		<%if(chk) { %>
			<%=id %>는 사용중입니다.<br><br>
			아이디 <input type="text" name="id">
			<input type="submit" value="중복 확인">
		<%}else{ %>
			<%=id %>는 사용가능합니다.<br><br>
			<input type="button" value="사용" onclick="checkIdClose()">
		<%} %>
	</form>
</body>
</html>