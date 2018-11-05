<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Struts2 ServletAPI Demo </title>
	</head>
	<body>
		<!-- <form action="servletApiLogin.action" method="post"> -->
		<form action="servletApiIocLogin.action" method="post">
			
			UserName: <input type="text" name="user.userName" /> <br>
			Password: <input type="password" name="user.password" /> <br>
			
			<button type="submit">login</button>
		</form>
	</body>
</html>