package deity.domain.control;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import deity.domain.service.SpringService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		SpringService springService = (SpringService) ac.getBean("springService");
		springService.addUser();
		springService.deleteUser();
	}
}
