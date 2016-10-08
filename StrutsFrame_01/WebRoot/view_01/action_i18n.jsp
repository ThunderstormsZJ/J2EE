<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<base href="<%=basePath%>">
</head>
<style type="text/css">
	span{
		line-height: 2em;
	}
</style>
<body>
	<h1>Chinese Dispose</h1>
	<form action="param_Param2" method="post">
		<input type="text" name="user.name"/>
		<input type="text" name="user.age"/>
		<input type="submit" value="提交">
	</form>
</body>
</html>
