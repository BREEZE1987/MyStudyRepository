<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Struts2 数据处理</title>
	</head>
	
	<body>
			
		<!-- 属性驱动 -->
		<form action="login.action" method="post">
			
			UserName: <input type="text" name="userName" /> <br>
			Password: <input type="password" name="password" />
			
			<!-- pYear: <input type="text" name="pYear" /> <br> -->
			<button type="submit">login</button>
		</form>	
			
		<!-- 对象驱动 -->
		<!-- <form action="login.action" method="post">
			<!-- UserName: <input type="text" name="user.userName" /> <br>
			Password: <input type="password" name="user.password" /> <br>
			
			<button type="submit">login</button>
		</form> -->
		
		<!-- 模型驱动 -->
		<!-- <form action="modelLogin.action" method="post">
			
			UserName: <input type="text" name="userName" /> <br>
			Password: <input type="password" name="password" /> <br>
			
			<button type="submit">login</button>
		</form> -->
	</body>
</html>