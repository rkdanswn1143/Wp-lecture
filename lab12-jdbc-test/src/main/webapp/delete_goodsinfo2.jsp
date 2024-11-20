<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error_page.jsp" %>
<%@ page import="java.sql.*,com.wp.goodsmanager.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 삭제</title>
</head>
<body>
	<h2>상품 정보를 삭제합니다...</h2>
<%
	String code = request.getParameter("code");
	if (code == null)  code = "10006";
	
 	DBConnectionInfo dbInfo = (DBConnectionInfo)application.getAttribute("db_info");
	GoodsinfoDAO dao = new GoodsinfoDAOImpl(dbInfo);

 
/* 	GoodsinfoDAO dao = new GoodsinfoDAObyDHCP(application.getInitParameter("dbcp_resource_name"));
 */ 

  	GoodsDO goods = new GoodsDO();
	goods.setCode(code);
	
	int result = dao.deleteGoods(goods);
	
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
%>
</body>
</html>