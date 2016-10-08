package deity.domain.hbl;

import java.util.List;

import org.hibernate.Query;
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
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
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

		for (int i = 1; i < 11; i++) {
			Edition edition = new Edition();
			edition.setName("edit" + i);
			Topic topic = new Topic();
			topic.setName("topic" + i);
			topic.setEdition(edition);
			Message message = new Message();
			message.setName("mes" + i);
			message.setTopic(topic);

			session.save(message);
		}

		// ------------------------------------
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testHQL01() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		/*
		 * 多对一的fetch为eager，会产生1+N问题
		 */
		List<Topic> topics = session.createQuery("From Topic").list();
		for (Topic topic : topics) {
			System.out.println(topic);
		}

		// ------------------------------------
		session.getTransaction().commit();
	}

	/*
	 * 分页显示
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testHQL02() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		List<Topic> topics = session.createQuery("From Topic")//
				.setMaxResults(5)//
				.setFirstResult(0)//
				.list();
		for (Topic topic : topics) {
			System.out.println(topic);
		}

		// ------------------------------------
		session.getTransaction().commit();
	}

	/*
	 * 参数的设置
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testHQL03() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		List<Topic> topics = session
				.createQuery("From Topic where id> :min and id< :max")//
				.setParameter("min", 1)//
				.setParameter("max", 5)//
				.list();
		for (Topic topic : topics) {
			System.out.println(topic);
		}

		// ------------------------------------
		session.getTransaction().commit();
	}

	@Test
	public void testHQL04() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		/*
		 * uniqueResult
		 */
		Long count = (Long) session.createQuery("select count(*) From Topic")//
				.uniqueResult();
		System.out.println(count);

		// ------------------------------------
		session.getTransaction().commit();
	}

	@Test
	public void testHQL05() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		Query q = session.createQuery("select t.id,t.name From Topic t");
		for (Object obj : q.list()) {
			Object[] topic = (Object[]) obj;
			System.out.println(topic[0]+"+"+topic[1]);
		}

		// ------------------------------------
		session.getTransaction().commit();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		sessionFactory.close();
	}
}
