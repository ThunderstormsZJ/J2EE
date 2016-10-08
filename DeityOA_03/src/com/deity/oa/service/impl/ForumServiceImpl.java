package com.deity.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import com.deity.oa.basic.impl.BasicDaoImpl;
import com.deity.oa.model.Forum;
import com.deity.oa.service.ForumService;

@Component
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends BasicDaoImpl<Forum> implements ForumService{
	@Override
	public List<Forum> findAll() {
		return getSession()//
				.createQuery("from Forum f order by f.position")//
				.list();
	}
	@Override
	public void add(Forum entity) {
		getSession().save(entity);
		entity.setPosition(entity.getId().intValue());//这里为持久化的对象，更改后会自动执行更新
	}
	//实现上移的功能
	public void moveUp(Long id) {
		Forum forum = (Forum) getSession().get(Forum.class, id);
		Forum target =  (Forum) getSession()//获取上移的目标对象
			.createQuery("from Forum f where f.position<? order by f.position desc")//
			.setParameter(0, forum.getPosition())//
			.setFirstResult(0)//
			.setMaxResults(1)//
			.uniqueResult();
		if(target==null){
			return ;
		}
		int temp = target.getPosition();
		//持久化对象不需要执行update方法
		target.setPosition(forum.getPosition());
		forum.setPosition(temp);
	}
	//实现下移的功能
	public void moveDown(Long id) {
		Forum forum = (Forum) getSession().get(Forum.class, id);
		Forum target = (Forum) getSession()//获取下移的目标对象
				.createQuery("from Forum f where f.position>? order by f.position asc")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		if(target == null){
			return ;
		}
		int temp = target.getPosition();
		target.setPosition(forum.getPosition());
		forum.setPosition(temp);
	}
}
