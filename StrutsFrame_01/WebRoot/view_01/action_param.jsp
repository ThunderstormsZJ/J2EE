<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
	span{line-height: 2em;}
	li{list-style:none;}
</style>
<body>
	<h1>Parameter Transmit</h1>
	<ul>
		<li>三种参数传递的方式</li>
		<li>
			<ul>
				<li>
					(1)在Action中写两个属性与参数名相对应
					<s:hidden name="name" value="frank"/>
					<a href="param_Param1?name=frank&age=21">方式一</a>
					<!-- <a href="param_Param1?age=21">方式一</a> -->
				</li>
				<li>
					(2)使用DomainDriver的方式接受参数
					<a href="param_Param2?user.name=jack&user.age=21">方式二</a>
				</li>
				<li>
					(3)通过继承ModelDriver的方式来接受参数
					<a href="param_Param3?name=marray&age=21">方式三</a>
				</li>
			</ul>
		</li>
	</ul>		
</body>
</html>
