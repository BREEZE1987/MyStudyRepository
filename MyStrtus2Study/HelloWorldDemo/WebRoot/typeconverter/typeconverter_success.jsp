<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>成功页面</title>
	</head>
	<body>
		点坐标：(${point.x}, ${point.y}) <br>
		
		${point} <br>
		
		ognl 表达式：<s:property value="point" />
		
	</body>
</html>