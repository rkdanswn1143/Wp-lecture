<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     
<%!
	int getIntervalSum(int start, int end) {
		int sum = 0;
		for (int i=start; i<=end; i++) {
			sum += i;
		}
		return sum;
	}
%>	
<%
	String start_= request.getParameter("start");
	String end_ = request.getParameter("end");
	
	int start = 0;
	if (start_ != null) {
		start = Integer.parseInt(start_);
	}
	int end = 0;
	if (end_ != null) {
		end = Integer.parseInt(end_);
	}
	
/* 	int sum = 0;
	for (int i=startNum; i<=endNum; i++) {
		sum += i;
	} */
	
	int sum = getIntervalSum(start, end);

%>
--%>
<%
	int start = (int)request.getAttribute("start");
	int end = (int)request.getAttribute("end");
	int sum = (int)request.getAttribute("sum");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interval Sum</title>
</head>
<body>
	<h1>구간 합 계산</h1><hr><br>
	<div>
<%--
	out.print("<b>"+ startNum + "에서 " + endNum + "까지 구간 합 = " + sum + "</b>");
--%>
		<b><%= start %>에서 까지 <%= end %>구간 합 = <%= sum %></b>	
	</div>
</body>
</html>