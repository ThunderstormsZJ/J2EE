<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>权限的配置</title>
    <%@ include file="/WEB-INF/view/public/common.jspf" %>
	<script type="text/javascript" src="script/jquery_treeview/jquery.treeview.js"></script>
	<link rel="stylesheet" type="text/css" href="script/jquery_treeview/jquery.treeview.css"/>
	<style type="text/css">
		label{font-size: 15px;}
	</style>
	<script type="text/javascript">
		$(function(){
			$("[name=priviledgeIds]").click(function(){
				//当一个被取消或选中时,它的下级都被取消或选中
				$(this).siblings("ul").find("input").attr("checked",this.checked);
				if(this.checked){
					//当一个被选中时,它的父级都被选中
					$(this).parents("li").children("input").attr("checked",true);
				}else{
					//inCheckedTree(this);
					if($(this).parent().siblings("li").children("input:checked").size()==0){
						$(this).parent().parent().siblings("input").attr("checked",false);
						var start = $(this).parent().parent().siblings("input");
							if($(start).parent().siblings("li").children("input:checked").size()==0){
								$(start).parent().parent().siblings("input").attr("checked",false);
							}
					}
				}
					
			});
		});
		function inCheckedTree(element){
			//当一个被取消时,判断兄弟节点是否被选中,没有一个被选中取消之间父级的选择
			if($(element).parent().siblings("li").children("input:checked").size()==0){
					$(element).parent().parent().siblings("input").attr("checked",false);
					var start = $(element).parent().parent().siblings("input");
					if(start!=null){
						inCheckedTree(start);
					}
			}
		}
	</script>
</head>
<body>
	<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 配置权限
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="sys/roleAction_setPriviledge.action">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> 正在为【${role.name}】配置权限 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                	<s:hidden name="id" value="%{id}"/>
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
								<input type="CHECKBOX" id="cbSelectAll" onClick="$(name=priviledgeIds).attr('checked',this.checked)"/>
								<label for="cbSelectAll">全选</label>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
								<!--  -->
								<ul id="tree" class="filetree">
								<!-- 第一层 -->
								<s:iterator value="#topList">
									<li>
										<input id="pi_${id}" name="priviledgeIds" type="checkbox" value="${id}" 
										<s:property value="%{id in priviledgeIds?'checked':''}"/>/>
										<span class="folder" style="display:inline;"><label>${name}</label></span>
										<!-- 第二层 -->
										<ul>
											<s:iterator value="children">
											<li>
												<input name="priviledgeIds" type="checkbox" value="${id}"
												<s:property value="%{id in priviledgeIds?'checked':''}"/>/>
												<span class="folder" style="display:inline;"><label>${name}</label></span>
												<!-- 第三层 -->
												<ul>
													<s:iterator value="children">
													<li>
														<input name="priviledgeIds" type="checkbox" value="${id}"
														<s:property value="%{id in priviledgeIds?'checked':''}"/>/>
														<span class="folder" style="display:inline;"><label>${name}</label></span>
													</li>
													</s:iterator>
												</ul>
											</li>
											</s:iterator>
										</ul>
									</li>
								</s:iterator>
								</ul>
								<!--  -->
							</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        <script type="text/javascript">
        	$("#tree").treeview();
        </script>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
	说明：<br />
	1，选中一个权限时：<br />
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该选中 他的所有直系上级。<br />
	&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br />
	2，取消选择一个权限时：<br />
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择 他的所有直系下级。<br />
	&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并递归向上做这个操作。<br />

	3，全选/取消全选。<br />
	4，默认选中当前岗位已有的权限。<br />
</div>
	    
</body>
</html>
