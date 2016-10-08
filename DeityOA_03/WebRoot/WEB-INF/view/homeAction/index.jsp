<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>OA系统</title>
    <%@ include file="/WEB-INF/view/public/common.jspf" %>
  </head>
  <frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
   		<frame src="home/homeAction_top.action" name="TopMenu"  scrolling="no" noresize />
    	<frameset cols="180,*" id="resize">
       		<frame noresize name="menu" src="home/homeAction_left.action" scrolling="yes" />
       	 	<frame noresize name="right" src="home/homeAction_right.action" scrolling="yes" />
    	</frameset>
   	 	<frame noresize name="status_bar" scrolling="no" src="home/homeAction_bottom.action" />
  </frameset>
  <noframes>
		<body>
		</body>
  </noframes>

</html>
