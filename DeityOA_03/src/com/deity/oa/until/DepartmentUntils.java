package com.deity.oa.until;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.deity.oa.model.Department;

public class DepartmentUntils {
	/**
	 * 显示树状图
	 * @param depts
	 * @return
	 */
	public static List<Department> treeView(List<Department> depts) {
		List<Department> list = new ArrayList<Department>();
		showTree(depts, "┫", list);
		return list;
	}
	/**
	 * 根据传入的集合将其转化为树状结构
	 * @param depts 	在转化之前的数据
	 * @param prefix	在树状前需要加的符号
	 * @param list		 用户保存树状之后的数据
	 */
	private static void showTree(Collection<Department> depts,String prefix,List<Department> list){
		for (Department department : depts) {
			Department dept = new Department();//原对象为Session的持久化对象,不能直接修改
			dept.setId(department.getId());
			dept.setName(prefix+department.getName());
			list.add(dept);
			//空格不能为半角的的
			showTree(department.getChildren(),"　"+prefix, list);
		}
	}
}
