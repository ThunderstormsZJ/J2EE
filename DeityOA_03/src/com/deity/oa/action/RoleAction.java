package com.deity.oa.action;

import java.util.HashSet;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.deity.oa.basic.BasicAction;
import com.deity.oa.model.Priviledge;
import com.deity.oa.model.Role;
import com.opensymphony.xwork2.ActionContext;


@Component
@Scope("prototype")
public class RoleAction extends BasicAction<Role>{
	private Long[] priviledgeIds;
	/** 列出所有的岗位*/
	public String list() throws Exception {
		List<Role> roles = roleServiceImpl.findAll();
		ActionContext.getContext().put("roles", roles);
		return "list";
	}
	/** 跳转到新建页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}
	/**增加岗位*/
	public String add() throws Exception {
		roleServiceImpl.add(model);
		return "tolist";
	}
	/** 删除指定的岗位 */
	public String delete() throws Exception {
		roleServiceImpl.delete(model.getId());
		return "tolist";
	}
	
	/**转到修改的页面*/
	public String editUI() throws Exception {
		//在转到修改页面之前准备好基本的回显数据
		Role role = roleServiceImpl.findById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	/**保存好修改的数据*/
	public String edit() throws Exception{
		//数据库中取出原对象
		Role role = roleServiceImpl.findById(model.getId());
		//从新设定更新的值
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		//保存更新
		roleServiceImpl.update(role);
		return "tolist";
	}
	/**转到权限页面*/
	public String setPriviledgeUI() throws Exception{
		//准备好岗位的信息
		Role role = roleServiceImpl.findById(model.getId());
		//准备回显的数据
		if(role.getPriviledges()!=null&&role.getPriviledges().size()>0){
			int index = 0;
			priviledgeIds = new Long[role.getPriviledges().size()];
			for(Priviledge priviledge:role.getPriviledges()){
				priviledgeIds[index++] = priviledge.getId();
			}
		}
		ActionContext.getContext().put("role", role);
		//准备顶级权限的数据
		List<Priviledge> topList = priviledgeServiceImpl.findTopList();
		ActionContext.getContext().put("topList", topList);
		return "setPriviledgeUI";
	}
	/**保存权限的设定*/
	public String setPriviledge() throws Exception{
		//得到所有的选定的权限
		List<Priviledge> priviledges = priviledgeServiceImpl.findByIds(priviledgeIds);
		//得到要设定的岗位
		Role role = roleServiceImpl.findById(model.getId());
		ActionContext.getContext().put("id",model.getId());
		//设置于岗位的关联关系
		role.setPriviledges(new HashSet<Priviledge>(priviledges));
		//更新岗位
		roleServiceImpl.update(role);
		return "toPriviledgeUI";
	}
	
	public Long[] getPriviledgeIds() {
		return priviledgeIds;
	}
	public void setPriviledgeIds(Long[] priviledgeIds) {
		this.priviledgeIds = priviledgeIds;
	}
}
