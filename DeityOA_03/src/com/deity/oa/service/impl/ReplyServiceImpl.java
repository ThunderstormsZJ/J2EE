package com.deity.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import com.deity.oa.basic.impl.BasicDaoImpl;
import com.deity.oa.model.Forum;
import com.deity.oa.model.Reply;
import com.deity.oa.model.Topic;
import com.deity.oa.service.ReplyService;

@Component
@SuppressWarnings("unchecked")
public class ReplyServiceImpl extends BasicDaoImpl<Reply> implements ReplyService{
	//实现更具版块查找所有的回复
	public List<Reply> findByTopic(Topic topic) {
		return getSession()//
				.createQuery("from Reply r where r.topic=? order by r.postTime")//
				.setParameter(0, topic)//
				.list();
	}
	//重写添加方法
	@Override
	public void add(Reply reply) {
		//维护主题关系
		Topic topic = reply.getTopic();
		topic.setReplyCount(topic.getReplyCount()+1);
		topic.setLastUpdateTime(topic.getPostTime());
		topic.setLastReply(reply);
		getSession().update(topic);
		//维护版块信息
		Forum forum = topic.getForum();
		forum.setArticleCount(forum.getArticleCount()+1);
		getSession().update(forum);
		getSession().save(reply);
	}
}
