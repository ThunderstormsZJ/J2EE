package deity.domain.a_helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class App {
	private static SessionFactory sessionFactroy = null;
	static {
		Configuration configuration = new Configuration()//
				.configure();
		// serviceRegisetery是hiberate4.0的新特性
		ServiceRegistry serviceRegisetry = new StandardServiceRegistryBuilder()//
				.applySettings(configuration.getProperties())//
				.build();
		sessionFactroy = configuration//
				.addClass(User.class)//
				.buildSessionFactory(serviceRegisetry);
	}

	// 保存到数据库
	@Test
	public void testSave() {
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		// ----------------------------------
		
		User user = new User();
		user.setName("天道");
		session.save(user);
		
		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// 从数据库中获取
	@Test
	public void testGet() {
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		// ----------------------------------
		
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
	
		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}
	
	//使用Annotation的方式将数据保存到数据库当中
	@Test
	public void testSave_teacher() throws Exception {
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		// ----------------------------------
		
		Teacher teacher = new Teacher();
		teacher.setId(1);
		teacher.setName("frank");
		teacher.setAge(21);
		session.save(teacher);
	
		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
