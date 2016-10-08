<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title></title>
</head>
<body>
	<a href="admin/category_addInput">增加</a>
	<a href="admin/category_delete">删除</a>
	<a href="admin/category_updateInput">修改</a><br/>
	<s:iterator value="categorys" var="c">
		<s:property value="#c.name"/>
	</s:iterator>
	<s:debug></s:debug>
</body>
</html>
