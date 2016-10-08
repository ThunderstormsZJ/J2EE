package com.deity.oa.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.impl.BasicDaoImpl;
import com.deity.oa.model.Department;
import com.deity.oa.service.DeptService;

@Component
@SuppressWarnings("unchecked")
public class DeptServiceImpl extends BasicDaoImpl<Department> implements DeptService{
	/**实现查询出所有的顶级部门*/
	public List<Department> findTopList() {
		return getSession().createQuery//
				("from Department d where d.parent.id is null")//
				.list();
	}
	/**查询所有的子部门*/
	public List<Department> findChildrenList(Long id) {
		return getSession().createQuery//
				("from Department d where d.parent.id=?")//
				.setParameter(0, id)
				.list();
	}
}
