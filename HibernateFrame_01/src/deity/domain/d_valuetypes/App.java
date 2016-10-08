package deity.domain.d_valuetypes;

import java.io.FileInputStream;
import java.util.Date;
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
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ----------------------------------

		FileInputStream fis = new FileInputStream("E:/TestDocument/1925371420.jpeg");
		byte[] image = new byte[fis.available()];
		fis.read(image);
		fis.close();
		
		RegisterByAn register = new RegisterByAn();
		register.setName("Frank");
		register.setExplain("aaaaaaaaaaaaaaaaaaaaaa");
		register.setBirthday(new Date());
		register.setImage(image);
		session.save(register);

		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}

	@AfterClass
	public static void AfterClass() {
		sessionFactory.close();
	}
}
