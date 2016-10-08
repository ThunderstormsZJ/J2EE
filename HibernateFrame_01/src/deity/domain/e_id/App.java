package deity.domain.e_id;

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
		// serviceRegisetery��hiberate4.0��������
		ServiceRegistry serviceRegisetry = new StandardServiceRegistryBuilder()//
				.applySettings(configuration.getProperties())//
				.build();
		sessionFactroy = configuration//
				//.addClass(Student.class)//
				.buildSessionFactory(serviceRegisetry);
	}

	// ���浽���ݿ�
	@Test
	public void testSave() {
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		// ----------------------------------
		
		Student student = new Student();
		student.setName("���");
		session.save(student);
		
		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testSaveTeacher() {
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		// ----------------------------------
		
		Teacher teacher = new Teacher();
		teacher.setName("���");
		session.save(teacher);
		
		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
