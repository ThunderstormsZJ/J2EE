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
		// serviceRegisetery��hiberate4.0��������
		ServiceRegistry serviceRegisetry = new StandardServiceRegistryBuilder()//
				.applySettings(configuration.getProperties())//
				.build();
		sessionFactroy = configuration//
				.addClass(User.class)//
				.buildSessionFactory(serviceRegisetry);
	}

	// ���浽���ݿ�
	@Test
	public void testSave() {
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		// ----------------------------------
		
		User user = new User();
		user.setName("���");
		session.save(user);
		
		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}

	// �����ݿ��л�ȡ
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
	
	//ʹ��Annotation�ķ�ʽ�����ݱ��浽���ݿ⵱��
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
