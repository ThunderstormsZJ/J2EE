<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>岗位列表</title>
    <%@ include file="/WEB-INF/view/public/common.jspf" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        <s:iterator value="roles">
			<tr class="TableDetail1 template">
				<td>${name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td><s:a onClick="return delConfirm()" href="sys/roleAction_delete.action?id=%{id}">删除</s:a>
					<s:a href="sys/roleAction_editUI.action?id=%{id}">修改</s:a>
					<s:a href="sys/roleAction_setPriviledgeUI.action?id=%{id}">设置权限</s:a>
				</td>
			</tr>
        </s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a href="sys/roleAction_addUI.action"><img src="style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>
</body>
</html>
