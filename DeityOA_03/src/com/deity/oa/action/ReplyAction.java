package com.deity.oa.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.BasicAction;
import com.deity.oa.model.Reply;
import com.deity.oa.model.Topic;

@Component
@Scope("prototype")
public class ReplyAction extends BasicAction<Reply>{
	private Long topicId;
	private Long forumId;
	//转到添加页面
	public String addUI() throws Exception {
		return "addUI";
	}
	//完成回复操作
	public String add() throws Exception {
		Topic topic = topicServiceImpl.findById(topicId);
		//手动设置值
		model.setTopic(topic);
		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getLocalAddr());
		model.setPostTime(new Date());
		replyServiceImpl.add(model);
		return "toListReplys";
	}
	
	//----------------
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
}
