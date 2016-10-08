<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>	Struts2 </title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		ol{line-height: 2em;}
		a{text-decoration: none;}
	</style>
  </head>
  
  <body>
  	<h1>Struts 2</h1>
  	<ol>
  	<li><a href="action_guide">Action Introduction</a></li>
  	<li><a href="action_nameSpace">NameSpace</a></li>
  	<li><a href="action_path">Path Problem</a></li>
  	<li><a href="action_method">Method Invoke</a></li>
  	<li><a href="action_param">Parameter Transmit</a></li>
  	<li><a href="action_i18n">Chinese Dispose</a></li>
  	<li><a href="action_validation">SimpleData Validation</a></li>
  	<li><a href="action_accesswebelements">Access Web Elements</a></li>
  	<li><a href="action_result">Result</a></li>
  	<li><a href="action_ognl">OGNL</a></li>
  	<li><a href="action_tags">Struts Tags</a></li>
  	</ol>
  </body>
</html>
