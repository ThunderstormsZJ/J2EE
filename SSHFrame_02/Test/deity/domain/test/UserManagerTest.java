package deity.domain.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import deity.domain.register.action.UserAction;
import deity.domain.register.model.User;
import deity.domain.register.service.UserManager;

public class UserManagerTest {
	@Test
	public void testExists() {
		ApplicationContext axt = new ClassPathXmlApplicationContext("bean.xml");
		UserManager userManager = (UserManager) axt.getBean("userManager");
		boolean result = userManager.exists("frank");
		assertEquals(true, result);
	}

	@Test
	public void testAdd(){
		ApplicationContext axt = new ClassPathXmlApplicationContext("bean.xml");
		UserManager userManager = (UserManager) axt.getBean("userManager");
		User user = new User();
		user.setUsername("Oracle");
		user.setPassword("frank");
		userManager.add(user);
	}
	
	@Test
	public void testAction(){
		ApplicationContext axt = new ClassPathXmlApplicationContext("bean.xml");
		//UserAction userManager = (UserAction) axt.getBean("userAction");
		UserManager userManager = (UserManager) axt.getBean("userManager");
		for (User user : userManager.listALl()) {
			System.out.println(user.getUsername());
		}
	}
}
