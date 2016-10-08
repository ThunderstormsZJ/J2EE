package deity.domain.associationM.f_student;

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
		
		Student student = new Student();
		student.setName("Frank");
		Course course = new Course();
		Course course1 = new Course();
		course.setCourseName("Psy");
		course1.setCourseName("java");
		Score score = new Score();
		Score score1 = new Score();
		
		score.setStudent(student);
		score.setCourse(course);
		score1.setStudent(student);
		score1.setCourse(course1);
		
		
		session.save(score);
		session.save(score1);

		// ------------------------------------
		session.getTransaction().commit();
	}

	@Test
	public void testGet() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------
		
		
		// ------------------------------------
		session.getTransaction().commit();
	}
	

	@AfterClass
	public static void afterClass() throws Exception {
		sessionFactory.close();
	}
}
