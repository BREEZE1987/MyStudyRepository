<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Struts2 的第一个案例</title>
	</head>
		
	<body>
		<h1> Hello Struts2 Index !</h1>
		
		<a href="<s:url action='hello' />">Hello world</a>
	</body>
</html>