<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="my_math_library" prefix="my" %>    
<!DOCTYPE html>
<%
	pageContext.setAttribute("result", 55);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%= session.getAttribute("user_name") %> 님, 환영합니다!</h3>
	<h3>${user_name} 님, 환영합니다!</h3>
	<p>1에서 100까지 합 : <%= request.getAttribute("result") %></p>
	<p>1에서 100까지 합 : ${result}</p>
	<p>1에서 100까지 합 : ${requestScope.result}</p>
	<p>개인 정보: 이름=${ps_info.name}, 성별=${ps_info.gender}, 나이=${ps_info["age"]}</p>
	<p>User-Agent header : ${header.User-Agent}</p>
	<p>User-Agent header : ${header["User-Agent"]}</p>
	<p>Accept Content-type: ${headerValues["Accept"][0]}</p>
	<p>1에서 101까지 합 : ${requestScope.result+101}</p>
	<p>1에서 101까지 합 : ${my:intervalSum(1,101)}</p>
	<p>10의 제곱근 : ${my:squareroot(10)}</p>
</body>
</html>