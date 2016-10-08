<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
 	<title>导航菜单</title>
 		<%@ include file="/WEB-INF/view/public/common.jspf" %>
		<script language="JavaScript" src="script/menu.js"></script>
		<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
	</head>
<body style="margin: 0">
<div id="Menu">
	<!-- 一级菜单 -->
    <ul id="MenuUl">
		<s:iterator value="#application.topPriviledgeList">
			<s:if test="#session.user!=null && #session.user.hasPriviledgeByName(name)">
			<li class="level1">
				<div onClick="menuClick(this)" class="level1Style" style="cursor:pointer;">
					<img src="style/images/MenuIcon/${ioc}" class="Icon" />${name}
				</div>
				<!-- 二级菜单 -->
				<ul style="display:none;" class="MenuLevel2">
					<s:iterator value="children">
						 <s:if test="#session.user!=null && #session.user.hasPriviledgeByName(name)">
						 <li class="level2">
                   			 <div class="level2Style" style="cursor:pointer;"><img src="style/images/MenuIcon/menu_arrow_single.gif" /> 
                   			 	<a target="right" href="${url}.action">${name}</a>
                   			 </div>
                		</li>
                		</s:if>
					</s:iterator>
				</ul>
			</li>
			</s:if>
		</s:iterator>
	</ul>
</div>
</body>
</html>
