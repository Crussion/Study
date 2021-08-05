<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	double num1 = Double.parseDouble(request.getParameter("num1"));
	double num2 = Double.parseDouble(request.getParameter("num2"));
	String generator = request.getParameter("generator");
	
	double result = 0;
	
	if(generator.equals("+")){
		result = num1 + num2;
	}else if(generator.equals("-")){
		result = num1 - num2;
	}else if(generator.equals("*")){
		result = num1 * num2;
	}else if(generator.equals("/")){
		result = num1 / num2;
	}else if(generator.equals("%")){
		result = num1 % num2;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=num1 %> <%=generator %> <%=num2 %> = <%=result %>
</body>
</html>