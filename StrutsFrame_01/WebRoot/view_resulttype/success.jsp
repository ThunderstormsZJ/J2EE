<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  	<h1>结果</h1>
    type为<s:property value="type"/><s:property value="#parameters.type"/>,跳转成功
    <s:debug></s:debug>
  </body>
</html>
