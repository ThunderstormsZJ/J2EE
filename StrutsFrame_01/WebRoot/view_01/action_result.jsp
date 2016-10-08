<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<style type="text/css">
span {line-height: 2em;}
a{text-decoration: none;}
ol{line-height: 2em;}
ul{line-height: 2em;}
ul li{list-style: none;}
div{float:left;width:300px;}
.dynamicResult{width:600px;}
</style>
</head>

<body>
	<h1>Result</h1>
	<div class="resultType">
	ResultType:
	<ol>
		<li><a href="dispatcher">dispatcher</a></li>
		<li><a href="redirect">redirect</a></li>
		<li><a href="chain">chain</a></li>
		<li><a href="redirectAction">redirectAction</a></li>
		<li>freemarker</li>
		<li>httpheader</li>
		<li>stream</li>
		<li>velocity</li>
		<li>xslt</li>
		<li>plaintext</li>
		<li>tiles</li>
	</ol>
	</div>
	<div class="dynamicResult">
		DynamicResult TranferDate:<br/>
		<ul>
			<li><a href="dynamicresult?type=1">动态参数的传递(success)</a></li>
			<li><a href="dynamicresult?type=2">动态参数的传递(fail)</a></li>
		</ul>
		Redirect DynamicResult:<br/>
		<ul>
			<li>在重定向时,参数传递后会保存在StackContext中</li>
			<li><a href="dynamicresultR?type=1">重定向动态参数的传递</a></li>
		</ul>
	</div>
</body>
</html>
