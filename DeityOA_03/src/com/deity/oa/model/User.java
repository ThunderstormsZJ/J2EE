package com.deity.oa.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.opensymphony.xwork2.ActionContext;

@Entity
@Table(name="deity_user")
public class User implements Serializable{
	private Long id;//主键
	private Department department;//所属部门
	private Set<Role> roles;//担任的岗位
	
	private String loginName;//登录名
	private String password;//登入密码
	private String name;//姓名
	private String gender;//性别
	private String phone;//联系电话
	private String email;//邮箱
	private String description;//描述
	
	//根据名字判断是否具有指定名称权限
	public boolean hasPriviledgeByName(String priviledgeName){
		//管理员具有所有的权限
		if(checkAdmin()){
			return true;
		}
		//不是管理员
		for (Role role : this.roles) {
			for(Priviledge priviledge : role.getPriviledges()){
				if(priviledge.getName().equals(priviledgeName)){
					return true;
				}
			}
		}
		return false;
	}
	//更具url地址判断是否有权限
	@SuppressWarnings("unchecked")
	public boolean hasPriviledgeByUrl(String priviledgeUrl) {
		if(checkAdmin()){
			return true;
		}
		List<String> priviledgeAllUrl = (List<String>) ActionContext.getContext()//
				.getApplication().get("priviledgeAllUrl");
		//editUI和edit是属于同一个权限
		if(priviledgeUrl.endsWith("UI")){
			priviledgeUrl = priviledgeUrl.substring(0, priviledgeUrl.length()-2);
		}
		if(priviledgeAllUrl.contains(priviledgeUrl)){
			//能够控制的权限判断
			//是否有权限在用户当中
			for(Role role : this.roles){
				for(Priviledge priviledge : role.getPriviledges()){
					if(priviledgeUrl!=null && priviledgeUrl.equals(priviledge.getUrl())){
						return true;
					}
				}
			}
		}else{
			//不能控制的权限所有的用户都能够使用
			return true;
		}
		return false;
	}
	//是否是管理员
	private boolean checkAdmin() {
		return "admin".equals(this.loginName);
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="dept_Id")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="deity_user_role",
		joinColumns={@JoinColumn(name="user_Id")},
		inverseJoinColumns={@JoinColumn(name="role_Id")})
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
