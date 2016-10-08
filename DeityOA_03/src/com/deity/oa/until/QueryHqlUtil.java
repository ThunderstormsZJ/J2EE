package com.deity.oa.until;

import java.util.ArrayList;
import java.util.List;
import com.deity.oa.basic.BasicDao;
import com.deity.oa.model.PageBean;
import com.opensymphony.xwork2.ActionContext;

public class QueryHqlUtil<T> {
	private String fromHql;// from 子句必须的
	private String whereHql = "";// where子句
	private String orderByHql = "";// orderBy子句

	private List<Object> parameters = new ArrayList<Object>();// 用来保存参数

	/*
	 * 默认语句，表的别名为t
	 */
	public QueryHqlUtil(Class<T> clazz) {
		fromHql = "from " + clazz.getSimpleName() + " t";
	}

	/*
	 * 自定义的别名
	 */
	public QueryHqlUtil(Class<T> clazz, String alias) {
		fromHql = "from " + clazz.getSimpleName() + " " + alias;
	}

	// 增加where子句
	public QueryHqlUtil<T> addCondition(String condition, Object... parameters) {
		if (whereHql.length() == 0) {
			whereHql = " where " + condition;
		} else {
			whereHql += " and " + condition;
		}
		// 保存参数
		if (parameters != null && parameters.length > 0) {
			for (Object parameter : parameters) {
				this.parameters.add(parameter);
			}
		}
		return this;
	}

	// 如果有追加
	public QueryHqlUtil<T> addCondition(boolean append, String condition,Object... parameters) {
		if (append) {
			addCondition(condition, parameters);
		}
		return this;
	}

	// 增加orderby子句
	public QueryHqlUtil<T> addOrder(String condition, boolean sortWay) {
		if(sortWay){
			//降序
			condition += " desc";
		}
		
		if(orderByHql.length()==0){
			orderByHql = " order by " + condition;
		}else{
			orderByHql += "," + condition;
		}
		return this;
	}

	// 有追加条件
	public QueryHqlUtil<T> addOrder(boolean append, String condition,boolean sortWay) {
		if(append){
			addOrder(condition, sortWay);
		}
		return this;
	}

	// -------------------------------
	//拼成完整语句
	public String getQueryHql(){
		return fromHql + whereHql + orderByHql;
	}
	//拼成获取总数的语句
	public String getQueryCount(){
		return "select count(*) " + getQueryHql();
	}
	//得到参数列表
	public List<Object> getParameters(){
		return parameters;
	}
	//将页面信息发到堆栈当中
	public void buildPageBeanForContext(int currentPage,BasicDao<T> service){
		PageBean<T> pageBean = service.getPageBean(currentPage, this);
		ActionContext.getContext().getValueStack().push(pageBean);
	}
}
