<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite List</title>
</head>
<body>
<%
	String userid = (String)request.getAttribute("userid");
%>
	<h1>Favorite List</h1><hr><br>
<%
	out.println("<p>반갑습니다, " + userid + "님!...</p>");
%>	
	<form action="output_list.do" method="GET">
		<p>
			좋아하는 스포츠는? <input type="text" name="sports">
			<input type="submit" value="등록">
		</p>
	</form>
</body>
</html>