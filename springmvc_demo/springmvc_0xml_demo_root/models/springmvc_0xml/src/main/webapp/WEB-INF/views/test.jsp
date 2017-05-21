<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测试 springMvc Servlet</title>
</head>
<body>
	<h1>Hello,This is a testing page!</h1>
	<form action="<%= request.getContextPath() %>/upload" enctype="multipart/form-data" method="post">
		<label>Name:</label><input type="text" name="picname"><br> 
		<!-- accept="image/jpeg,image/png,image/gif" -->
		<label>file：</label><input type="file" name="profilePicture"	><br> 
		<input type="submit">
	</form>
</body>
</html>