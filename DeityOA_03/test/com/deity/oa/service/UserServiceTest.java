package com.deity.oa.service;

import org.junit.Test;


public class UserServiceTest {
	@Test
	public void testService() {
		/*ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserAction userAction = act.getBean("userAction", UserAction.class);*/
		String url = "?userAction_list.actionid=1";
		int pos = url.indexOf("?");
		System.out.println(url.indexOf("?"));
		System.out.println(url.substring(1));
	}
}
