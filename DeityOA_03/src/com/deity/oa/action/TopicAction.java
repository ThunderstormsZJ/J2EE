package com.deity.oa.action;

import java.util.Date;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.BasicAction;
import com.deity.oa.model.Reply;
import com.deity.oa.model.Topic;
import com.deity.oa.until.QueryHqlUtil;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class TopicAction extends BasicAction<Topic>{
	private Long forumId;
	/**转到发表新帖页面*/
	public String addUI() throws Exception{
		return "addUI";
	}
	/**发表新帖*/
	public String add() throws Exception{
		//设置于版块的关系
		model.setForum(forumServiceImpl.findById(forumId));
		//设置属性
		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getLocalAddr());
		model.setPostTime(new Date());
		topicServiceImpl.add(model);
		return "toListTopics";
	}
	/**显示所有的回复*/
	public String listReplys() throws Exception{
		//得到主题的信息
		Topic topic = topicServiceImpl.findById(model.getId());
		ActionContext.getContext().put("topic", topic);
		//得到主题下的所有的回复
		/*List<Reply> replys = replyServiceImpl.findByTopic(topic);
		ActionContext.getContext().put("replys", replys);*/
		new QueryHqlUtil<Reply>(Reply.class,"r")//
			.addCondition("r.topic=?", topic)//
			.addOrder("r.postTime", true)//
			.buildPageBeanForContext(currentPage, replyServiceImpl);
		return "listReplys";
	}
	/**设置精华类型*/
	public String setBest() throws Exception{
		//获取要设置的主题
		Topic topic = topicServiceImpl.findById(model.getId());
		//设置类型和根更新
		topic.setType(Topic.TYPE_BEST);
		topicServiceImpl.update(topic);
		return "toListTopics";
	}
	/**设置普通类型*/
	public String setNormal() throws Exception{
		//获取要设置的主题
		Topic topic = topicServiceImpl.findById(model.getId());
		//设置类型和根更新
		topic.setType(Topic.TYPE_NORMAL);
		topicServiceImpl.update(topic);
		return "toListTopics";
	}
	/**设置置顶类型*/
	public String setTop() throws Exception{
		//获取要设置的主题
		Topic topic = topicServiceImpl.findById(model.getId());
		//设置类型和根更新
		topic.setType(Topic.TYPE_TOP);
		topicServiceImpl.update(topic);
		return "toListTopics";
	}
	//-----------------------
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
	
}
