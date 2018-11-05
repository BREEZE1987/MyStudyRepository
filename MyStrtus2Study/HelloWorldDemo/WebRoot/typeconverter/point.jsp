<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Point Type Converter Page </title>
	</head>
	<body>
		<form action="typeConverter.action" method="post">
			点：<input type="text" name="point" />
			<input type="submit" value="提交">
		</form>
	</body>
</html>