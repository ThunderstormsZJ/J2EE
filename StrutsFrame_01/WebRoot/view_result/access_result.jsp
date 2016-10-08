<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  	<h1>结果</h1>
    request:<s:property value="#request.frank"/>|${requestScope.frank}<br/>
    session:<s:property value="#session.jack"/>|${sessionScope.jack}<br/>
    application:<s:property value="#application.rose"/>|${applicationScope.rose}<br/>
    <s:debug></s:debug>
  </body>
</html>
