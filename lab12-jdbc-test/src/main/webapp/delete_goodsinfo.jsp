<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 삭제</title>
</head>
<body>
	<h2>상품 정보를 삭제합니다...</h2>
<%
	String jdbcDriverName = "org.h2.Driver";
	String url = "jdbc:h2:tcp://localhost/~/test";
	String username = "sa";
	String password = "";
	
	Connection conn = null;
	Statement stmt = null;
	
	Class.forName(jdbcDriverName);
	conn = DriverManager.getConnection(url, username, password);

	if (conn != null) {
		stmt = conn.createStatement();

 		String sql = "delete from goodsinfo where code='10006'";
		int result = stmt.executeUpdate(sql);
	
		if (result > 0) {
%>		
		<h2>상품 정보을 정상적으로 삭제하였습니다.</h2>
<%		
		}
		else {
%>
		<h2>상품 정보 삭제에 실패하였습니다.</h2>
<%		
		}
		
		stmt.close();
		conn.close();
	}
	else {
%>
		<h2>DB 연결에 실패하였습니다.</h2>				
<%		
	}
%>
</body>
</html>