package deity.domain.control;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import deity.domain.domain.User;
import deity.domain.service.UserService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		UserService springService = (UserService) ac.getBean("userService");
		/*User user = new User();
		user.setName("rose");
		springService.addUser(user);*/
		List<User> users = springService.findAll();
		System.out.println(users.size());
	}
}
