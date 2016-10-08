package com.deity.oa.service;

import java.util.List;
import com.deity.oa.basic.BasicDao;
import com.deity.oa.model.Forum;
import com.deity.oa.model.PageBean;
import com.deity.oa.model.Topic;

public interface TopicService extends BasicDao<Topic>{
	
	/**
	 * 按照置顶帖排序
	 * @param forum
	 * @return
	 */
	@Deprecated
	List<Topic> findByForum(Forum forum);
	/**
	 * 得到主题页面的分页数据
	 */
	@Deprecated
	PageBean<Topic> getPageBean(int currentPage , Forum forum);
	
}
