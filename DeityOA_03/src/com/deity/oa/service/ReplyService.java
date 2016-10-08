package com.deity.oa.service;

import java.util.List;

import com.deity.oa.basic.BasicDao;
import com.deity.oa.model.Reply;
import com.deity.oa.model.Topic;

public interface ReplyService extends BasicDao<Reply>{
	/**
	 * 根据查找所有的回复
	 * @param topic
	 * @return
	 */
	@Deprecated
	List<Reply> findByTopic(Topic topic);

}
