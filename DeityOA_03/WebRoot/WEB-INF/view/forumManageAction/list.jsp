<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>版块列表</title>
    <%@ include file="/WEB-INF/view/public/common.jspf" %>
    <style type="text/css">
    	.disableA{color:grey;cursor:pointer;}
    </style>
</head>

<body>
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 版块管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="250px">版块名称</td>
                <td width="300px">版块说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="forumList">
        <s:iterator value="#forums" status="status">
			<tr class="TableDetail1 template">
				<td>${name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td><s:a onClick="return delConfirm()" href="co/forumManageAction_delete.action?id=%{id}">删除</s:a>
					<s:a href="co/forumManageAction_editUI.action?id=%{id}">修改</s:a>
					<!-- 上移 -->
					<s:if test="#status.first">
						<span class="disableA">下移</span>
					</s:if>
					<s:else>
						<s:a href="co/forumManageAction_moveUp.action?id=%{id}">上移</s:a>
					</s:else>
					<!-- 下移 -->
					<s:if test="#status.last">
						<span class="disableA">上移</span>
					</s:if>
					<s:else>
						<s:a href="co/forumManageAction_moveDown.action?id=%{id}">下移</s:a>
					</s:else>
				</td>
			</tr>
        </s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a href="co/forumManageAction_addUI.action"><img src="style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>

<div class="Description">
	说明：<br />
	1，显示的列表按其sortOrder值升序排列。<br />
	2，可以通过上移与下移功能调整顺序。最上面的不能上移，最下面的不能下移。<br />
</div>

</body>
</html>
