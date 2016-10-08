<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户列表</title>
    <%@ include file="/WEB-INF/view/public/common.jspf" %>
</head>

<body>
<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        	<s:iterator value="#users">
	            <tr class="TableDetail1 template">
	                <td>${loginName}&nbsp;</td>
	                <td>${name}&nbsp;</td>
	                <td>${department.name}&nbsp;</td>
	                <td>
	                <s:iterator value="roles">
	                	${name}
	                </s:iterator>
	                &nbsp;
	                </td>
	                <td>${description}&nbsp;</td>
	                <td><s:a onClick="return delConfirm()" href="sys/userAction_delete.action?id=%{id}">删除</s:a>
	                    <s:a href="sys/userAction_editUI.action?id=%{id}">修改</s:a>
						<s:a href="sys/userAction_initPassword.action?id=%{id}" onClick="return window.confirm('您确定要初始化密码为12345吗？')">初始化密码</s:a>
	                </td>
	            </tr>
        	</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a href="sys/userAction_addUI.action"><img src="style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>
</body>
</html>

