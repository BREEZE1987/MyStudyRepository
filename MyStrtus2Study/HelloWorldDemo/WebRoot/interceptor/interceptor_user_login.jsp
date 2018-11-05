<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Struts2 拦截器</title>
	</head>
	
	<body>
		<form action="interceptorUserLogin.action" method="post">
			
			UserName: <input type="text" name="user.userName" /> 
			<s:fielderror fieldName="user.userName"></s:fielderror>
			<br>
			Password: <input type="password" name="user.password" />
		
			<button type="submit">Login</button>
		</form>	
	</body>
</html>