<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户列表页面</title>
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#btn").click(function() {
					$.post("list.action", function(data) {
						var html = "";
						for (var i = 0; i < data.length; i++) {
							html += "<tr><td>" + data[i].userName 
							+ "</td><td>" + data[i].password 
							+ "</td></tr>"
						}
						$("#content").html(html);
					}, "json");
				});
			});
		</script>
	</head>
	<body>
		<button id="btn">获取数据</button>
		<table width="80%" align="center">
			<thead>
				<tr>
					<td>用户名</td>
					<td>密码</td>
				</tr>
			</thead>
			<tbody id="content">
			</tbody>
		</table>
	</body>
</html>