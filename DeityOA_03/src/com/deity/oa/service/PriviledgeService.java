package com.deity.oa.service;

import java.util.List;

import com.deity.oa.basic.BasicDao;
import com.deity.oa.model.Priviledge;

public interface PriviledgeService extends BasicDao<Priviledge>{
	/**
	 * 查找最高级的权限
	 * @return
	 */
	List<Priviledge> findTopList();
	/**
	 * 查找所有的url
	 * @return
	 */
	List<String> findAllUrl();
}
