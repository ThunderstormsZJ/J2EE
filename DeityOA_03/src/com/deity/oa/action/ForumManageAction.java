package com.deity.oa.action;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.BasicAction;
import com.deity.oa.model.Forum;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class ForumManageAction extends BasicAction<Forum>{
	/** 列出所有的版块信息*/
	public String list() throws Exception{
		List<Forum> forums = forumServiceImpl.findAll();
		ActionContext.getContext().put("forums", forums);
		return "list";
	}
	/** 删除版块信息*/
	public String delete() throws Exception{
		forumServiceImpl.delete(model.getId());
		return "tolist";
	}
	/** 转到添加页面*/
	public String addUI() throws Exception {
		return "saveUI";
	}
	/** 保存添加的版块信息*/
	public String add() throws Exception {
		forumServiceImpl.add(model);
		return "tolist";
	}
	/**转到修改的页面*/
	public String editUI() throws Exception {
		// 准备回显的数据
		Forum forum = forumServiceImpl.findById(model.getId());
		ActionContext.getContext().getValueStack().push(forum);
		return "saveUI";
	}
	/**保存好修改的数据*/
	public String edit() throws Exception {
		Forum forum = forumServiceImpl.findById(model.getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumServiceImpl.update(forum);
		return "tolist";
	}
	/**上移功能*/
	public String moveUp() throws Exception {
		forumServiceImpl.moveUp(model.getId());
		return "tolist";
	}
	/**下移功能*/
	public String moveDown() throws Exception {
		forumServiceImpl.moveDown(model.getId());
		return "tolist";
	}
}
