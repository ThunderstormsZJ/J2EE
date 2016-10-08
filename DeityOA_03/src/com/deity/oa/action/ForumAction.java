package com.deity.oa.action;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.BasicAction;
import com.deity.oa.model.Forum;
import com.deity.oa.model.Topic;
import com.deity.oa.until.QueryHqlUtil;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class ForumAction extends BasicAction<Forum> {
	private int topicType;// 根据主题主题类型过滤
	private int sortType;// 排序的种类
	private boolean sortWay;// 排序的方式

	/** 列出所有的版块信息 */
	public String list() throws Exception {
		List<Forum> forums = forumServiceImpl.findAll();
		ActionContext.getContext().put("forums", forums);
		return "list";
	}

	/** 列出单个版块信息下的主题信息 */
	public String listTopics() throws Exception {
		Forum forum = forumServiceImpl.findById(model.getId());
		ActionContext.getContext().put("forum", forum);
		// 按照一定的顺序排序
		// List<Topic> topics = topicServiceImpl.findByForum(forum);
		// 得到分页信息
		//PageBean<Topic> pageBean = topicServiceImpl.getPageBean(currentPage,forum);
		//String queryHql =
		//"from Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc,t.postTime desc";
		new QueryHqlUtil<Topic>(Topic.class)//
				.addCondition("t.forum=?", forum)//
				.addCondition(topicType==1, "t.type=?" , Topic.TYPE_BEST)//
				.addOrder(sortType==0,"(case t.type when 2 then 2 else 0 end)",true)//
				.addOrder(sortType==0,"t.postTime", sortWay)//
				.addOrder(sortType==1,"t.lastUpdateTime",sortWay)//
				.addOrder(sortType==2,"t.postTime",sortWay)//
				.addOrder(sortType==3,"t.replyCount",sortWay)//
				.buildPageBeanForContext(currentPage,topicServiceImpl);
		//PageBean<Topic> pageBean = topicServiceImpl.getPageBean(currentPage,queryHql, forum);
		//ActionContext.getContext().getValueStack().push(pageBean);
		return "listTopic";
	}

	// -----------------------
	public int getTopicType() {
		return topicType;
	}

	public void setTopicType(int topicType) {
		this.topicType = topicType;
	}

	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
	}

	public boolean isSortWay() {
		return sortWay;
	}

	public void setSortWay(boolean sortWay) {
		this.sortWay = sortWay;
	}

}
