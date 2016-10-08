package com.deity.oa.action;

import java.util.HashSet;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import com.deity.oa.basic.BasicAction;
import com.deity.oa.model.Role;
import com.deity.oa.model.User;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class UserAction extends BasicAction<User>{
	private Long departmentId;
	private Long[] roleIdList;
	
	/**显示所有的信息*/
	public String list() throws Exception {
		List<User> users = userServiceImpl.findAll();
		ActionContext.getContext().put("users", users);//放入Stack Context中
		//System.out.println(users.size());
		return "list";
	}
	/** 删除用户信息*/
	public String delete() throws Exception {
		userServiceImpl.delete(model.getId());
		return "tolist";
	}
	/**转到添加页面 */
	public String addUI() throws Exception {
		//准备树状部门数据、
		ActionContext.getContext().put("treeList", toTree());
		//准备岗位数据
		ActionContext.getContext().put("roleList", roleServiceImpl.findAll());
		return "saveUI";
	}
	/** 保存用户信息*/
	public String add() throws Exception {
		//如果用户存在跳转到错误页面
		if(userServiceImpl.findByLoginName(model.getLoginName())==null){
			//设置所属部门
			model.setDepartment(deptServiceImpl.findById(departmentId));
			//设置所处岗位
			model.setRoles(new HashSet<Role>(roleServiceImpl.findByIds(roleIdList)));
			userServiceImpl.add(model);
			return "tolist";
		}else{
			// 跳转到错误页面
			this.addFieldError("noAdd", "用户名已经存在!");
			return "toErrorUI";
		}
	}
	/**转到修改的页面*/
	public String editUI() throws Exception {
		//准备树状部门数据
		ActionContext.getContext().put("treeList", toTree());
		//准备好岗位信息
		ActionContext.getContext().put("roleList", roleServiceImpl.findAll());
		//在转到修改页面之前准备好基本的回显数据
		User user = userServiceImpl.findById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		//准备好部门的回显信息
		if(user.getDepartment()!=null){
			departmentId = user.getDepartment().getId();
		}
		//岗位的回显信息
		if(user.getRoles()!=null&&user.getRoles().size()>0){
			roleIdList = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIdList[index++] = role.getId();
			}
		}
		return "saveUI";
	}
	/**保存好修改的数据*/
	public String edit() throws Exception{
		//修改后的数据存在就跳转到错误页面
		//数据库中取出原对象
		User user = userServiceImpl.findById(model.getId());
		if(user.getLoginName().equals(model.getLoginName()) ||
					userServiceImpl.findByLoginName(model.getLoginName())==null){
			//从新设定更新的值
			user.setLoginName(model.getLoginName());
			user.setName(model.getName());
			user.setGender(model.getGender());
			user.setPhone(model.getPhone());
			user.setEmail(model.getEmail());
			user.setDescription(model.getDescription());
			//设定关联关系
			user.setDepartment(deptServiceImpl.findById(departmentId));
			user.setRoles(new HashSet<Role>(roleServiceImpl.findByIds(roleIdList)));
			//保存更新
			userServiceImpl.update(user);
			return "tolist";
		}else{
			// 跳转到错误页面
			this.addFieldError("noAdd", "用户名已经存在!");
			return "toErrorUI";
		}
	}
	/**转到登录页面*/
	public String loginUI() throws Exception{
		return "loginUI";
	}
	/**判断登录信息*/
	public String login() throws Exception{
		User user = userServiceImpl.checkUser(model);
		if(user!=null){
			//用户存在将用户保存到session中
			ActionContext.getContext().getSession().put("user", user);
			return "toHome";
		}else{
			//不存在转到错误页面
			this.addFieldError("inexits", "用户不存在");
			return "toErrorUI";
		}
	}
	/**用户注销*/
	public String logOut() throws Exception{
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	/**初始化密码*/
	public String initPassword() throws Exception{
		User user = userServiceImpl.findById(model.getId());
		//将密码重置为123
		user.setPassword(DigestUtils.md5DigestAsHex("12345".getBytes()));
		userServiceImpl.update(user);
		return "tolist";
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long[] getRoleIdList() {
		return roleIdList;
	}
	public void setRoleIdList(Long[] roleIdList) {
		this.roleIdList = roleIdList;
	}
}
