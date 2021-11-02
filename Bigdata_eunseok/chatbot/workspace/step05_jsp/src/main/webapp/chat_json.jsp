<%@page import="org.json.JSONObject"%>
<%@page import="java.net.http.HttpResponse"%>
<%@page import="java.net.URI"%>
<%@page import="java.net.http.HttpRequest"%>
<%@page import="java.net.http.HttpClient"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String query = request.getParameter("query");
	
	String url = "http://localhost:5000/query/TEST?query=" + URLEncoder.encode(query);
	
	HttpClient client = HttpClient.newHttpClient();
	
	HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
	HttpResponse<String> httpResponse = client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).get();
	
	String result = httpResponse.body();
	JSONObject json = new JSONObject(result);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=result %>
</body>
</html>