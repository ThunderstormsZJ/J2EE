package com.deity.oa.install;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import com.deity.oa.model.Priviledge;
import com.deity.oa.model.User;

@Component
public class Installer {
	//初始化程序
	private SessionFactory sessionFactory;
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		//一、加载超级管理员
		//---------------------------------
		User user = new User();
		user.setName("超级管理员");
		user.setLoginName("admin");
		user.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));
		session.save(user);
		//---------------------------------
		//二、保存初始化的数据
		//---------------------------------
		//1.系统设置模块(sys)
		Priviledge menu,menu1,menu2,menu3,menu4,menu5;
		menu = new Priviledge(null, "系统管理", null, "FUNC20082.gif");
		menu1 = new Priviledge(menu, "岗位管理", "sys/roleAction_list", null);
		menu2 = new Priviledge(menu, "部门管理", "sys/deptAction_list", null);
		menu3 = new Priviledge(menu, "用户管理", "sys/userAction_list", null);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		
		session.save(new Priviledge(menu1,"岗位列表","sys/roleAction_list",null));
		session.save(new Priviledge(menu1,"岗位增加","sys/roleAction_add",null));
		session.save(new Priviledge(menu1,"岗位删除","sys/roleAction_delete",null));
		session.save(new Priviledge(menu1,"岗位修改","sys/roleAction_edit",null));
		session.save(new Priviledge(menu1,"设置权限","sys/roleAction_setPriviledge",null));
		
		session.save(new Priviledge(menu2,"部门列表","sys/deptAction_list",null));
		session.save(new Priviledge(menu2,"部门增加","sys/deptAction_add",null));
		session.save(new Priviledge(menu2,"部门删除","sys/deptAction_delete",null));
		session.save(new Priviledge(menu2,"部门修改","sys/deptAction_edit",null));
		
		session.save(new Priviledge(menu3,"用户列表","sys/userAction_list",null));
		session.save(new Priviledge(menu3,"用户增加","sys/userAction_add",null));
		session.save(new Priviledge(menu3,"用户删除","sys/userAction_delete",null));
		session.save(new Priviledge(menu3,"用户修改","sys/userAction_edit",null));
		session.save(new Priviledge(menu3,"初始化密码","sys/userAction_initPassword",null));
		//---------------------------------
		//2.网上交流(co(chatOnline))
		menu = new Priviledge(null, "网上交流", null, "FUNC20064.gif");
		menu1 = new Priviledge(menu, "短消息", "co/messageAction", null);
		menu2 = new Priviledge(menu, "论坛", "co/forumAction_list", null);
		menu3 = new Priviledge(menu, "论坛管理", "co/forumManageAction_list", null);
		menu4 = new Priviledge(menu, "投票", "co/voteAction", null);
		menu5 = new Priviledge(menu, "实时聊天", "co/chatAction", null);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
		//---------------------------------
		//3.审批流转
		menu = new Priviledge(null, "审批流转", null, "FUNC20057.gif");
		menu1 = new Priviledge(menu, "审批流程管理", "flow/processDefinitionAction", null);
		menu2 = new Priviledge(menu, "表单模板管理", "flow/formTemplateManageAction", null);
		menu3 = new Priviledge(menu, "起草申请", "flow/formTemplateAction", null);
		menu4 = new Priviledge(menu, "待我审批", "flow/myTaskvoteAction", null);
		menu5 = new Priviledge(menu, "我的申请查询", "flow/mySubmittedAction", null);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
	}
	
	public static void main(String[] args) {
		System.out.println("初始化:正在准备数据........");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = ac.getBean("installer", Installer.class);
		installer.install();
		System.out.println("初始化完毕！");
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
