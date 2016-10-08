package com.deity.oa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="deity_dept")
public class Department implements Serializable{
	private Long id;//主键
	private Department parent;//上级部门
	private Set<Department> children = new HashSet<Department>();//下级部门
	private Set<User> users = new HashSet<User>();//部门员工
	
	private String name;//部门名称
	private String description;//部门描述
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="parent_Id")
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL)
	@OrderBy("name desc")//取出来的子部门按名称降序排列
	public Set<Department> getChildren() {
		return children;
	}
	public void setChildren(Set<Department> children) {
		this.children = children;
	}
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
