package com.deity.oa.listener;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.deity.oa.model.Priviledge;
import com.deity.oa.service.PriviledgeService;

public class InitServletContextListener implements ServletContextListener{
	//初始化,准备好数据
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		//得到PrivilegeServiceImpl实例对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		PriviledgeService priviledgeServiceImpl = ac.getBean("priviledgeServiceImpl", PriviledgeService.class);
		//取得所有的顶级菜单的信息,保存到ServletContext中
		List<Priviledge> topPriviledgeList = priviledgeServiceImpl.findTopList();
		servletContext.setAttribute("topPriviledgeList", topPriviledgeList);
		//准备好所有的Url
		List<String> priviledgeAllUrl = priviledgeServiceImpl.findAllUrl();
		servletContext.setAttribute("priviledgeAllUrl", priviledgeAllUrl);
		System.out.println("数据准备完毕!");
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}


}
