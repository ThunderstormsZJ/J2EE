package com.deity.oa.service;

import com.deity.oa.basic.BasicDao;
import com.deity.oa.model.Forum;

public interface ForumService extends BasicDao<Forum>{
	/**
	 * 上移功能
	 * @param position
	 * @return 
	 */
	void moveUp(Long id);
	/**
	 * 下移功能
	 * @param id
	 */
	void moveDown(Long id);

}
