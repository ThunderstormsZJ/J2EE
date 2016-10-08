package com.deity.oa.action;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.BasicAction;
import com.deity.oa.model.Department;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class DeptAction extends BasicAction<Department> {
	private Long parentId;//得到上级部门的Id
	/** 列出所有的部门信息*/
	public String list() throws Exception {
		List<Department> depts = null;
		if(parentId==null || parentId<1){
			//如果id为空列从顶级部门
			depts = deptServiceImpl.findTopList();
			System.out.println("null");
		}else{
			//如果id不为空列出子部门
			depts = deptServiceImpl.findChildrenList(parentId);
			Department parent = deptServiceImpl.findById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("depts", depts);
		return "list";
	}
	/** 删除部门信息*/
	public String delete() throws Exception {
		deptServiceImpl.delete(model.getId());
		return "tolist";
	}
	/** 转到添加页面*/
	public String addUI() throws Exception {
		ActionContext.getContext().put("treeList", toTree());
		return "saveUI";
	}
	/** 保存添加的部门信息*/
	public String add() throws Exception {
		//设置上级部门的关联
		model.setParent(deptServiceImpl.findById(parentId));
		deptServiceImpl.add(model);
		return "tolist";
	}
	/**转到修改的页面*/
	public String editUI() throws Exception {
		//准备好部门的树状数据
		ActionContext.getContext().put("treeList", toTree());
		//在转到修改页面之前准备好基本的回显数据
		Department dept = deptServiceImpl.findById(model.getId());
		ActionContext.getContext().getValueStack().push(dept);
		//上级部门的回显信息
		if(dept.getParent()!=null){
			parentId = dept.getParent().getId();
		}
		return "saveUI";
	}
	/**保存好修改的数据*/
	public String edit() throws Exception{
		//数据库中取出原对象
		Department dept = deptServiceImpl.findById(model.getId());
		//从新设定更新的值
		dept.setName(model.getName());
		dept.setDescription(model.getDescription());
		//设定关联关系
		dept.setParent(deptServiceImpl.findById(parentId));
		//保存更新
		deptServiceImpl.update(dept);
		return "tolist";
	}
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
