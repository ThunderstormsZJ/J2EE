package com.deity.oa.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.impl.BasicDaoImpl;
import com.deity.oa.model.Priviledge;
import com.deity.oa.service.PriviledgeService;

@SuppressWarnings("unchecked")
@Component
public class PriviledgeServiceImpl extends BasicDaoImpl<Priviledge> implements PriviledgeService{
	//实现查找顶级权限
	public List<Priviledge> findTopList() {
		return getSession().createQuery("from Priviledge p where p.parent is null")//
				.list();
	}
	//实现查找所有的url
	public List<String> findAllUrl() {
		return getSession()//
				.createQuery("select p.url from Priviledge p")//
				.list();
	}
}
