package com.deity.oa.basic;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;
import com.deity.oa.model.Department;
import com.deity.oa.model.User;
import com.deity.oa.service.DeptService;
import com.deity.oa.service.ForumService;
import com.deity.oa.service.PriviledgeService;
import com.deity.oa.service.ReplyService;
import com.deity.oa.service.RoleService;
import com.deity.oa.service.TopicService;
import com.deity.oa.service.UserService;
import com.deity.oa.until.DepartmentUntils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BasicAction<T> extends ActionSupport implements ModelDriven<T>{
	protected T model;
	protected int currentPage = 1;
	//父类列出所有的Service类,方便子类的调用
	protected DeptService deptServiceImpl;
	protected RoleService roleServiceImpl;
	protected UserService userServiceImpl;
	protected PriviledgeService priviledgeServiceImpl;
	protected ForumService forumServiceImpl;
	protected TopicService topicServiceImpl;
	protected ReplyService replyServiceImpl;
	
	public BasicAction() {
		//获取model的实际类型将其初始化
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取T的实际类型
		Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
		try {
			//初始化model
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

	//树形转换
	protected List<Department> toTree(){
		//准备好上级部门的显示信息
		//查询出所有的顶级部门
		List<Department> topList = deptServiceImpl.findTopList();
		//准备成树状图保存到集合当中
		List<Department> treeList = DepartmentUntils.treeView(topList);
		return treeList;
	}
	//获取当前的用户
	protected User getCurrentUser(){
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	@Override
	public T getModel() {
		return model;
	}
	
	//------------------------
	public DeptService getDeptServiceImpl() {
		return deptServiceImpl;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Resource
	public void setDeptServiceImpl(DeptService deptServiceImpl) {
		this.deptServiceImpl = deptServiceImpl;
	}
	public RoleService getRoleServiceImpl() {
		return roleServiceImpl;
	}
	@Resource
	public void setRoleServiceImpl(RoleService roleServiceImpl) {
		this.roleServiceImpl = roleServiceImpl;
	}
	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}
	@Resource
	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	public PriviledgeService getPriviledgeServiceImpl() {
		return priviledgeServiceImpl;
	}
	@Resource
	public void setPriviledgeServiceImpl(PriviledgeService priviledgeServiceImpl) {
		this.priviledgeServiceImpl = priviledgeServiceImpl;
	}
	public ForumService getForumServiceImpl() {
		return forumServiceImpl;
	}
	@Resource
	public void setForumServiceImpl(ForumService forumServiceImpl) {
		this.forumServiceImpl = forumServiceImpl;
	}
	public TopicService getTopicServiceImpl() {
		return topicServiceImpl;
	}
	@Resource
	public void setTopicServiceImpl(TopicService topicServiceImpl) {
		this.topicServiceImpl = topicServiceImpl;
	}
	public ReplyService getReplyServiceImpl() {
		return replyServiceImpl;
	}
	@Resource
	public void setReplyServiceImpl(ReplyService replyServiceImpl) {
		this.replyServiceImpl = replyServiceImpl;
	}
	
	
}
