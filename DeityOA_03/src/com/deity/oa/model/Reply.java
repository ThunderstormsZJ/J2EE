package com.deity.oa.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="deity_reply")
public class Reply extends Article implements Serializable{
	//关联属性
	private Topic topic;
	
	//-------------------------
	@ManyToOne
	@JoinColumn(name="topic_Id")
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
