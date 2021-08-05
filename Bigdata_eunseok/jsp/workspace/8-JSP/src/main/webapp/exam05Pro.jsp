<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String kor = request.getParameter("kor");
	String eng = request.getParameter("eng");
	String math = request.getParameter("math");
	
	int total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
	double avg = total / 3.0;
	
	String grade;
	
	if(avg > 90) grade = "수";
	else if(avg > 80) grade = "우";
	else if(avg > 70) grade = "미";
	else if(avg > 60) grade = "양";
	else grade = "가";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=name %>님의 성적은 "<%=grade %>"입니다.
</body>
</html>