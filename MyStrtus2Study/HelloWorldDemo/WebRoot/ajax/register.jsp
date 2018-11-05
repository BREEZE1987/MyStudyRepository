<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ajax 注册页面</title>
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#uName").blur(function() {
					//alert($(this).val());
					$.post(
							"checkName.action",
							{"user.userName":$(this).val()},
							function(data) {
								if ("true" == data) {
									$("#uName").css("border", "1px solid red");
								} else {
									$("#uName").css("border", "1px solid green");
								}
							});
				});
			});
		</script>
	</head>
	<body>
		userName:<input type="text" name="user.userName" id="uName" />
		
	</body>
</html>