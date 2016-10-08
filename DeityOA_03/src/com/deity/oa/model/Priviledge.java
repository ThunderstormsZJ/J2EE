package com.deity.oa.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="deity_priviledge")
public class Priviledge implements Serializable{
	private Long id;//主键
	private Set<Role> roles;//该权限下的所有岗位
	private Priviledge parent;//上级权限
	private Set<Priviledge> children;//所有子权限
	
	private String name;//权限的名称
	private String url;//权限的url地址
	private String ioc;//权限的图标路径
	
	public Priviledge() {}
	public Priviledge(Priviledge parent, String name, String url, String ioc) {
		this.parent = parent;
		this.name = name;
		this.url = url;
		this.ioc = ioc;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToMany(mappedBy="priviledges",cascade=CascadeType.ALL)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@ManyToOne
	@JoinColumn(name="parent_Id")
	public Priviledge getParent() {
		return parent;
	}
	public void setParent(Priviledge parent) {
		this.parent = parent;
	}
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@OrderBy("name desc")
	public Set<Priviledge> getChildren() {
		return children;
	}
	public void setChildren(Set<Priviledge> children) {
		this.children = children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIoc() {
		return ioc;
	}
	public void setIoc(String ioc) {
		this.ioc = ioc;
	}
}
