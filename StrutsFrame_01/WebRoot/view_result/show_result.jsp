<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  	<h1>结果</h1>
    <s:property value="actionMessages[0]"/>
    <s:property value="errors.name[0]"/>
    <s:debug></s:debug>
  </body>
</html>
