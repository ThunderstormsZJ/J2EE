package deity.domain.associationM.a_one2one_xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class App {
	private static SessionFactory sessionFactory = null;

	@BeforeClass
	public static void beforeClass() throws Exception {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
				.applySettings(configuration.getProperties())//
				.build();
		sessionFactory = configuration//
				.addClass(Husband.class)//
				.addClass(Wife.class)//
				.buildSessionFactory(serviceRegistry);
	}

	@Test
	public void testBulidTable() throws Exception {
		// 手动建表方法
		new SchemaExport(new Configuration().configure()).create(false, true);
	}

	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		Wife wife = new Wife();
		wife.setName("Rose");
		Husband husband = new Husband();
		husband.setName("Jack");

		husband.setWife(wife);

		session.save(husband);
		session.save(wife);
		// ------------------------------------

		session.getTransaction().commit();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		sessionFactory.close();
	}
}
