package com.deity.oa.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.impl.BasicDaoImpl;
import com.deity.oa.conf.Configure;
import com.deity.oa.model.Forum;
import com.deity.oa.model.PageBean;
import com.deity.oa.model.Topic;
import com.deity.oa.service.TopicService;

@Component
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends BasicDaoImpl<Topic> implements TopicService{
	//按照置顶帖排序
	public List<Topic> findByForum(Forum forum) {
		return getSession()//
		.createQuery("from Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc,t.lastUpdateTime desc")//
		.setParameter(0, forum)//
		.list();
	}
	//重写增加方法，增加维护关系
	@Override
	public void add(Topic topic) {
		topic.setLastUpdateTime(topic.getPostTime());
		getSession().save(topic);
		
		//维护版块的信息
		Forum forum = topic.getForum();
		forum.setTopicCount(forum.getTopicCount()+1);
		forum.setArticleCount(forum.getArticleCount()+1);
		forum.setLastTopic(topic);
		getSession().update(forum);
	}
	//得到主题页面的信息
	public PageBean<Topic> getPageBean(int currentPage,Forum forum) {
		int pageSize = Configure.pageSize;
		//查询本页的数据
		List<Topic> topics = getSession()//
				.createQuery("from Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc,t.lastUpdateTime desc")//
				.setParameter(0, forum)//
				.setFirstResult((currentPage-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();
		//读取总的记录数
		Long recordCount = (Long) getSession()//
				.createQuery("select count(*) from Topic t where t.forum=?")//
				.setParameter(0, forum)//
				.uniqueResult();
		return new PageBean<Topic>(currentPage, pageSize, topics, recordCount.intValue());
	}
}