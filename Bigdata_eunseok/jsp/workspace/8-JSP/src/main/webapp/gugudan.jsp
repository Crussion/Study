<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	out.print("<table>");
	
	for(int i = 1; i <= 9; i++){
		out.print("<tr>");
		for(int j = 2; j <= 9; j++){
			out.print("<td>");
			out.print(String.format("%d * %d = %d", j, i, i*j));
			out.print("</td>");
		}
		out.print("</tr>");
	}
	
	out.print("</table>")
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td { border: 1px solid black; padding: 5px; }
</style>
</head>
<body>
	<table border="1">
		<%for (int i = 1; i <= 9; i++) {%>
			<tr>
			<%for (int j = 2; j <= 9; j++) {%>
				<td>
				<%=j + "*" + i + "=" + j*i%>
				</td>
			<%} %>
			</tr>
		<%} %>
	</table>
</body>
</html>