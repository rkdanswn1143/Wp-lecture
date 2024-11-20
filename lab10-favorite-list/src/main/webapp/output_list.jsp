<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite List</title>
</head>
<body>
<%
	String userid = (String)request.getAttribute("userid");
	Map<String, String> list = (Map<String, String>)request.getAttribute("list");
%>
	<h1>Favorite List</h1><hr><br>
<%
	out.println("<p>반갑습니다, " + userid + "님!...</p>");
%>	
	<p>당신이 좋하는 것들:</p>
	<ul>
<%
	Set<String> keys = list.keySet();
	for (String key : keys) {
		out.println("<li>" + key + " : " + list.get(key) + "</li>");
	}
%>	
	</ul><br><br>
	<input type="button" value="첫페이지>>" onclick="location.href='login.html';">
</body>
</html>