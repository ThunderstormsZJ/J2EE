package com.deity.oa.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="deity_topic")
public class Topic extends Article implements Serializable{
	public static final int TYPE_NORMAL = 0;//普通帖
	public static final int TYPE_BEST = 1;//精华帖
	public static final int TYPE_TOP = 2;//置顶帖
	//----一般属性----
	private int type;//帖子的类型
	//----特殊属性----
	private int replyCount;//回复的数量
	private java.util.Date lastUpdateTime;//最后更新的时间
	//----关联属性----
	private Forum forum;
	private Set<Reply> replys;
	private Reply lastReply;
	
	//-----------------------------
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	@ManyToOne
	@JoinColumn(name="forum_Id")
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	@OneToMany(mappedBy="topic",cascade=CascadeType.ALL)
	public Set<Reply> getReplys() {
		return replys;
	}
	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}
	@OneToOne
	@JoinColumn(name="lastReply_Id")
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
}
