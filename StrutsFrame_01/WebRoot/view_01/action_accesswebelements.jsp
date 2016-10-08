<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<base href="<%=basePath%>">
</head>
<style type="text/css">
span {
	line-height: 2em;
}
</style>
<body>
	<h1>Access Web Elements</h1>
	<form name="f" action="" method="post">
	<span>
		取得Map类型request,session,application:<br/>
		 *Ioc方式:<input type="submit" value="提交1" 
		 onclick="javascript:document.f.action='access_Login1';document.f.submit();"> <br/>
		 依赖容器:<input type="submit" value="提交2" 
		 onclick="javascript:document.f.action='access_Login2';document.f.submit();"> <br/>
		真实类型HttpServletRequest,HttpSession,ServletContext的引用:<br/>
		 Ioc方式:<input type="submit" value="提交3" 
		 onclick="javascript:document.f.action='access_Login3';document.f.submit();"> <br/>
		 依赖容器:<input type="submit" value="提交4" 
		 onclick="javascript:document.f.action='access_Login4';document.f.submit();"> <br/>
	</span>
	</form>
</body>
</html>
