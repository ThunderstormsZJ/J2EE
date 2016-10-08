package com.deity.oa.basic;

import java.util.List;

import com.deity.oa.model.PageBean;
import com.deity.oa.until.QueryHqlUtil;

public interface BasicDao<T> {
	/**
	 * 增加实体
	 * @param entity
	 */
	public void add(T entity);
	/**
	 * 更新实体
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 查询所有的实体
	 * @return List<T>
	 */
	public List<T> findAll();
	/**
	 * 删除指定的实体
	 * @param id
	 */
	public void delete(Long id);
	/**
	 * 根据ID查找的实体信息
	 * @param id
	 */
	public T findById(Long id);
	/**
	 * 查询多个id的实体信息
	 * @param ids
	 * @return
	 */
	public List<T> findByIds(Long[] ids);
	/**
	 * 获取分页信息
	 * @param currentPage
	 * @param queryHql
	 * @param parameters
	 * @return
	 */
	@Deprecated
	public PageBean<T> getPageBean(int currentPage,String queryHql,Object... parameters);
	/**
	 * 优化获取分页信息方法
	 * @param currentPage
	 * @param queryHqlUtil
	 * @return
	 */
	public PageBean<T> getPageBean(int currentPage,QueryHqlUtil<T> queryHqlUtil);
}
