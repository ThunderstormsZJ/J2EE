<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<style type="text/css">
	span{line-height: 2em;}
	ol{line-height: 2em;}
	a{text-decoration: none;}
</style>
</head>

<body>
	<h1>OGNL</h1>
	全称:Object Graph Navigation Language<br/>
	<ol>
		<li><a href="action_ognl?username=frank">
			访问值栈中的action的普通属性:</a><s:property value="username"/></li>
		<li><a href="action_ognl?user.name=frank&user.age=23">
			访问值栈中对象的普通属性(get set方法):</a><s:property value="user"/>/
			<s:property value="user.name"/>/<s:property value="user['age']"/></li>
		<li><a href="action_ognl?user.name=frank&user.age=23">
			访问值栈中对象的普通属性(get set方法):</a><s:property value="user"/>/
			<s:property value="user.card"/></li>
		<li><a href="action_ognl">
			访问值栈中对象的普通方法:</a><s:property value="user.card.cardId.length()"/></li>
		<li><a href="action_ognl">
			访问静态属性:</a><s:property value="@deity.domain.ognl.Card@staticFiled"/></li>
		<li><a href="action_ognl">
			访问List:</a><s:property value="userList"/>/<s:property value="userList[0]"/>
			/<s:property value="userList.{name}"/>/<s:property value="userList.{name}[0]"/></li>
		<li><a href="action_ognl">
			访问Set(获取不了特定值):</a><s:property value="userSet"/>/<s:property value="userSet[0]"/></li>
		<li><a href="action_ognl">
			访问Map:</a><s:property value="userMap"/>/<s:property value="userMap['1']"/>
			/<s:property value="userMap.keys"/>/<s:property value="userMap.values"/></li>
		<li><a href="action_ognl">
			投影(过滤):</a><s:property value="userList.{?#this.name=='Jack1'}[0]"/>/
			<s:property value="userList.{^#this.age>20}.{name}"/>/
			<s:property value="userList.{$#this.age>20}.{name}"/>/
			<s:property value="userList.{$#this.age>22}.{age}==null"/></li>
		<li><a href="action_ognl">
			[]:</a><s:property value="[0].userList"/></li>
		<s:debug/>
	</ol>
</body>
</html>
