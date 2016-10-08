<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<style type="text/css">
	span{
		line-height: 2em;
	}
</style>
</head>
<body>
	<h1>Action Introduction</h1>
	<span>
	01.Struts1只会创建一个Action,而Sturts2每次访问都会创建一个新的Action<br /> 
	02.具体视图的返回可以由用户自己定义的Action来决定<br /> 
	03.具体的手段是根据返回的字符串找到对应的配置项，来决定视图的内容<br /> 
	04.具体Action的实现可以是一个普通的java类，里面有public String execute方法即可<br /> 
	05.或者实现Action接口<br />
	06.不过最常用的是从ActionSupport继承，好处在于可以直接使用Struts2封装好的方法<br />
	</span>
</body>
</html>
