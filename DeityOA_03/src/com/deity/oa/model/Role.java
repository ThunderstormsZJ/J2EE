package com.deity.oa.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="deity_role")
public class Role implements Serializable{
	private Long id;//主键
	private Set<User> users;//包含的所有员工
	private Set<Priviledge> priviledges;//该岗位下的所有的权限
	
	private String name;//岗位名称
	private String description;//岗位描述
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToMany(mappedBy="roles",cascade=CascadeType.ALL)
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="deity_role_priviledge",
		joinColumns={@JoinColumn(name="role_Id")},
		inverseJoinColumns={@JoinColumn(name="priviledge_Id")})
	public Set<Priviledge> getPriviledges() {
		return priviledges;
	}
	public void setPriviledges(Set<Priviledge> priviledges) {
		this.priviledges = priviledges;
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
