<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body style="text-align: center;">
	<div>
		<img src="error.jpeg">
	</div>
	<div>
		<h2>오류: <%= exception.getMessage() %></h2>
	</div>
</body>
</html>