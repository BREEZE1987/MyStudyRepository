<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>文件上传页面</title>
	</head>
	<body>
		<form action="batchUpload.action" method="post" enctype="multipart/form-data">
			文件：<input type="file" name="file" /> <br>
			文件：<input type="file" name="file" /> <br>
			文件：<input type="file" name="file" /> <br>
			<input type="submit" value="上传" />
		</form>
	</body>
</html>