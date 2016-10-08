package com.deity.oa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="deity_article")
public class Article implements Serializable{
	//----一般属性----
	private Long id;//主键
	private String title;//文章标题
	private String content;//文章内容
	private String faceIoc;//文章图标
	private java.util.Date postTime;//文章发表时间
	private String ipAddr;//发表的IP地址
	//----关联关系----
	private User author;//作者
	
	//---------------------
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(columnDefinition="text",length=20000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFaceIoc() {
		return faceIoc;
	}
	public void setFaceIoc(String faceIoc) {
		this.faceIoc = faceIoc;
	}
	public java.util.Date getPostTime() {
		return postTime;
	}
	public void setPostTime(java.util.Date postTime) {
		this.postTime = postTime;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	@OneToOne
	@JoinColumn(name="user_Id")
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
}
