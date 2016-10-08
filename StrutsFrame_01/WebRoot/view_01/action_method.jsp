<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<style type="text/css">
	li{
		list-style:none;	
	}
</style>
</head>

<body>
	<h1>Method Invoke</h1>
	01.Action执行的时候并不一定要执行execute方法<br />
	02.有以下三种方法来调用方法 <br/>
	<ul>
		<li>a.可以在配置文件中配置Action的时候用method=来指定执行哪个方法</li>
		<li>
			<ul>
				<li>(1)在Action中写好方法名</li>
				<li>(2)配置Action是使用method属性指定调用的方法名</li>
			</ul>
		</li>
	</ul>
	<ul>
		<li>b.可以在url地址中动态指定（动态方法调用DMI）（推荐）</li>
		<li>
			<ul>
				<li>(1)在Action中写好方法名</li>
				<li>(2)调用的方法名在url地址用！连接</li>
				<li>(3)struts.xml文件中设置struts.enable.DynamicMethodInvocation属性为true</li>
			</ul>
		</li>
	</ul>
	<ul>
		<li>c.可以使用通配符的方式来调用方法(约定优于配置)</li>
		<li>
			<ul>
				<li>(1)配置Action中的name属性时采用通配符的形式</li>
				<li>(2)根据约定命名方法和url名</li>
			</ul>
		</li>
	</ul>
	【注】前者会产生太多的action，所以不推荐使用
</body>
</html>
