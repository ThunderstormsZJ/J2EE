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
div{float:left;width:600px;}
</style>
</head>

<body>
	<h1>Struts Tags</h1>
	<div class="resultType">
	<ol>
		<li>set 设定adminName值（默认为request 和 ActionContext）: 
			<s:set var="adminName" value="username" scope="session"/></li>
		<li>
			bean 定义bean,并使用param来设定新的属性值:
			<s:bean name="deity.domain.domain.User" >
				<s:param name="name" value="'Frank'"></s:param>
				<s:property value="name"/>
			</s:bean>
		</li>
		
		<li>遍历集合：<br />
			<s:iterator value="{1, 2, 3}" >
				<s:property/> |
			</s:iterator>
		</li>
		<li>自定义变量：<br />
			<s:iterator value="{'aaa', 'bbb', 'ccc'}" var="x">
				<s:property value="#x.toUpperCase()"/> |
			</s:iterator>
		</li>
		<li>使用status:<br />
			<s:iterator value="{'aaa', 'bbb', 'ccc'}" status="status">
				<s:property/> | 
				遍历过的元素总数：<s:property value="#status.count"/> |
				遍历过的元素索引：<s:property value="#status.index"/> |
				当前是偶数？：<s:property value="#status.even"/> |
				当前是奇数？：<s:property value="#status.odd"/> |
				是第一个元素吗？：<s:property value="#status.first"/> |
				是最后一个元素吗？：<s:property value="#status.last"/>
				<br />
			</s:iterator>
		</li>
		<li>
			<s:iterator value="#{1:'a', 2:'b', 3:'c'}" >
				<s:property value="key"/> | <s:property value="value"/> <br />
			</s:iterator>
		</li>
		<li>
			<s:iterator value="#{1:'a', 2:'b', 3:'c'}" var="x">
				<s:property value="#x.key"/> | <s:property value="#x.value"/> <br />
			</s:iterator>
		</li>
		<li>
		<s:fielderror fieldName="errors" theme="simple"></s:fielderror>
		</li>
	</ol>
	<s:debug/>
	</div>
	<div>
	<ol>
		
	</ol>
	</div>
</body>
</html>
