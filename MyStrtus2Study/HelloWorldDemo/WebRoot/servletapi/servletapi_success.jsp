<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Login Success Page </title>
	</head>
	<body>
		登录成功，欢迎：${sessionScope.currentUser.userName} <br>
		密码：${requestScope.password}
	</body>
</html>