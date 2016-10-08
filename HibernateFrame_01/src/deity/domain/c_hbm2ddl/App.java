package deity.domain.c_hbm2ddl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class App {
	private static SessionFactory sessionFactory = null;

	@BeforeClass
	public static void beforeClass() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
				.applySettings(configuration.getProperties())//
				.build();
		sessionFactory = configuration//
				.buildSessionFactory(serviceRegistry);
	}

	// 保存到数据库
	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ----------------------------------

		Student student = new Student();
		student.setId(5);
		student.setName("天道");
		session.save(student);

		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// 从数据库中获取
	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ----------------------------------

		Student student = (Student) session.get(Student.class, 1);
		System.out.println(student);

		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}

	@AfterClass
	public static void AfterClass() {
		sessionFactory.close();
	}
}
