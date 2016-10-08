package com.deity.oa.basic.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import com.deity.oa.basic.BasicDao;
import com.deity.oa.conf.Configure;
import com.deity.oa.model.PageBean;
import com.deity.oa.until.QueryHqlUtil;

@SuppressWarnings("unchecked")
//不能在子类开启事务
@Transactional
public class BasicDaoImpl<T> implements BasicDao<T> {
	private SessionFactory sessionFactory;
	private Class<T> clazz;//获取泛型类型
	
	public BasicDaoImpl() {
		//获取泛型类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		//System.out.println(pt);//com.deity.oa.basicdao.impl.BasicDaoImpl<com.deity.oa.model.User>
		//获取实际参数类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		//System.out.println(clazz);//class com.deity.oa.model.User
	}
	//增加实体的实现
	public void add(T entity) {
		getSession().save(entity);
	}
	//更新实体的实现
	public void update(T entity) {
		getSession().update(entity);
	}
	//查询所有实体的实现
	public List<T> findAll() {
		return getSession()//
				.createQuery("From "+clazz.getName())//
				.list();
	}
	//删除实体的实现
	public void delete(Long id) {
		getSession().delete(getSession().get(clazz, id));
	}
	//根据id查询实体的实现
	public T findById(Long id) {
		return (T) getSession().get(clazz, id);
	}
	// 根据ids查询实体实现
	public List<T> findByIds(Long[] ids) {
		if(ids==null||ids.length==0){
			//防止数组的控空值针异常
			return Collections.EMPTY_LIST;
		}
		System.out.println(clazz.getName()+":"+clazz.getSimpleName());
		return getSession().createQuery(//
				"from "+clazz.getName()+" where id in(:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}
	//实现得到分页信息的方法
	public PageBean<T> getPageBean(int currentPage,String queryHql,Object... parameters){
		int pageSize = Configure.pageSize;
		//查询本页的数据
		/*List<T> entitys = getSession()//
				.createQuery(queryHql)//
				.setParameter(0, entity)//
				.setFirstResult((currentPage-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();*/
		Query listQuery = getSession().createQuery(queryHql);
		//设置参数
		if(parameters!=null&&parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				listQuery.setParameter(i, parameters[i]);
			}
		}
		listQuery.setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize);
		List<T> list = listQuery.list();
		
		//读取总的记录数
		/*Long recordCount = (Long) getSession()//
				.createQuery("select count(*) from Topic t where t.forum=?")//
				.setParameter(0, entity)//
				.uniqueResult();*/
		//queryHql = queryHql.substring(0,queryHql.indexOf("?")+1);//截取后面没有语句
		Query countQuery = getSession().createQuery("select count(*) "+queryHql);
		//设置参数
		if(parameters!=null&&parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				countQuery.setParameter(i, parameters[i]);
			}
		}
		Long recordCount = (Long) countQuery.uniqueResult();
		return new PageBean<T>(currentPage, pageSize, list, recordCount.intValue());
	}
	//优化分页方法
	public PageBean<T> getPageBean(int currentPage,QueryHqlUtil<T> queryHqlUtil){
		int pageSize = Configure.pageSize;
		String queryHql = queryHqlUtil.getQueryHql();
		List<Object> parameters = queryHqlUtil.getParameters();
		
		Query listQuery = getSession().createQuery(queryHql);
		//设置参数
		if(parameters!=null&&parameters.size()>0){
			for(int i=0;i<parameters.size();i++){
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize);
		List<T> list = listQuery.list();
		
		//queryHql = queryHql.substring(0,queryHql.indexOf("?")+1);//截取后面没有语句
		Query countQuery = getSession().createQuery(queryHqlUtil.getQueryCount());
		//设置参数
		if(parameters!=null&&parameters.size()>0){
			for(int i=0;i<parameters.size();i++){
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		//countQuery.setParameter(0, parameters.get(0));
		Long recordCount = (Long) countQuery.uniqueResult();
		return new PageBean<T>(currentPage, pageSize, list, recordCount.intValue());
	}
	/**
	 * 得到Session
	 * return Session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
