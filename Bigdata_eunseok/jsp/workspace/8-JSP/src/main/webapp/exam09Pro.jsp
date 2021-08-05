<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	String result = "";
	boolean chk = false;
	if(!id.equals("root")){
		result = "아이디가 존재하지 않습니다.";
	}else if(!pwd.equals("1234")){
		result = "비밀번호가 틀립니다.";
	}else{
		result = "로그인에 성공했습니다.";
		chk = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		alert(<%=result%>);
		history.back();
	}
</script>
</head>
<body>
	<%=result %>
</body>
</html>