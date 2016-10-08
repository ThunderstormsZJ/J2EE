<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
</head>
<style type="text/css">
	span{
		line-height: 2em;
	}
</style>
<body>
	<h1>Path</h1>
	<span>
	01.struts2中的路径问题是根据action的路径而不是jsp路径来确定，所以尽量不要使用相对路径。
	<a href="Index.jsp">Index.jsp</a><br /> 
	02.虽然可以用redirect方式解决，但redirect方式并非必要。<br /> 
	03.解决办法非常简单，统一使用绝对路径。（在jsp中用request.getContextRoot方式来拿到webapp的路径）<br /> 
	04.或者使用myeclipse经常用的，指定basePath
	</span>
</body>
</html>
