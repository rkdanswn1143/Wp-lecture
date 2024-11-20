<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wp.listenertest.*" %>    
<%
	DBConnectionInfo dbConnInfo = (DBConnectionInfo)request.getAttribute("db_info");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listener Test</title>
</head>
<body>
	<h1>Listener Test</h1>
	<h3>ServletContext & ServletRequest event listener</h3><hr><br>
	<div>
		<h3>DB Connection Information:</h3>
		<ol>
			<li>Oracle JDBC Driver : <%= dbConnInfo.getJdbcDriverName() %></li>
			<li>DB URL : <%= dbConnInfo.getUrl() %></li>
			<li>DB Userid : <%= dbConnInfo.getUserid() %></li>
			<li>DB Password : <%= dbConnInfo.getPassword() %></li>
			<li>DB Table : <%= dbConnInfo.getTable() %></li>
		</ol>
	</div>
</body>
</html>