<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>错误</title>
    <%@ include file="/WEB-INF/view/public/common.jspf" %>
  </head>
  
  <body>
    <DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
	        <DIV ID="Title"><!--页面标题-->
	            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="style/images/title_arrow.gif"/> 提示
	        </DIV>
	        <DIV ID="Title_End"></DIV>
    	</DIV>
	</DIV>

	<!--显示表单内容-->
	<DIV ID="MainArea">
			<DIV CLASS="ItemBlock_Title1">
	        </DIV> 
	
	        <DIV CLASS="ItemBlockBorder" STYLE="margin-left: 15px;">
	            <DIV CLASS="ItemBlock" STYLE="text-align: center; font-size: 16px;">
	              	<s:fielderror></s:fielderror>
	            </DIV>
	        </DIV>
	        
	        <!-- 操作 -->
	        <DIV ID="InputDetailBar">
	            <A HREF="javascript:history.go(-1);"><IMG SRC="style/images/goBack.png"/></A>
	        </DIV>
	</DIV>
  </body>
</html>
