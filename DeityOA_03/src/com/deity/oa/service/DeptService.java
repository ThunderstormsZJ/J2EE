package com.deity.oa.service;

import java.util.List;

import com.deity.oa.basic.BasicDao;
import com.deity.oa.model.Department;

public interface DeptService extends BasicDao<Department>{
	//查询所有的顶级部门
	public List<Department> findTopList();

	public List<Department> findChildrenList(Long id);

}
