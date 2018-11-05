<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录成功页面</title>
	</head>
	<body>
		<%-- 登录成功：欢迎 ${userName}<br> --%>
		
		<%-- ${pYear} --%>
		
		<%-- 登录成功：欢迎 ${user.userName}<br> --%>
		
		登录成功：欢迎 ${userName}<br>
		
		<!-- value 填写 ognl 表达式 -->
		用户：<s:property value="userName" /> <br>
		地址：<s:property value="#application.address" /> <br>
		<s:property value="#parameters.userName"/> <br>
	</body>
</html>