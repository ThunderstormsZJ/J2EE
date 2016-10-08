package com.deity.oa.interceptor;

import com.deity.oa.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPriviledgeUrlInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//测试
		/*System.out.println("之前");
		String result = invocation.invoke();
		System.out.println("之后");
		return result;*/
		//得到session中的用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		//得到当前访问的url
		String actionName = invocation.getProxy().getActionName();
		String nameSpace = invocation.getProxy().getNamespace();
		//System.out.println(actionName+ "+" +nameSpace);//测试:userAction_list+/sys
		String priviledgeUrl = null;
		if(nameSpace.endsWith("/")){
			priviledgeUrl = actionName + nameSpace;
		}else{
			priviledgeUrl = nameSpace + "/" + actionName;
			if(priviledgeUrl.startsWith("/")){
				priviledgeUrl = priviledgeUrl.substring(1);
			}
		}
		//　用户已经登录
		if(user!=null){
			//　如果有权限就允许url访问
			if(priviledgeUrl!=null && user.hasPriviledgeByUrl(priviledgeUrl)){
				return invocation.invoke();
			}else{
				//没有权限就跳转到错误页面
				ActionSupport action = (ActionSupport) invocation.getAction();
				action.addFieldError("noPriviledge", "您没有访问该功能的权限");
				return "toErrorUI";
			}
			
		}else{
			if(priviledgeUrl.startsWith("sys/userAction_login")){
				//如果正在执行登录
				return invocation.invoke();
			}else{
				//用户没有登录
				//就直接跳转到登录页面
				return "loginUI";
			}
		}
	}

}
