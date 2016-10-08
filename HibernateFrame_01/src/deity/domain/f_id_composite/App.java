package deity.domain.f_id_composite;

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
				// .addClass(Student.class)//
				.buildSessionFactory(serviceRegisetry);
	}

	// 保存到数据库
	@Test
	public void testSave() {
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		// ----------------------------------

		Com_FK com_FK = new Com_FK();
		com_FK.setId(1);
		com_FK.setName("Jack");
		Student student = new Student();
		student.setCom_FK(com_FK);
		student.setAge(21);
		student.setSubject("数学");
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

		/*
		 * Teacher_FK fk = new Teacher_FK(); fk.setId(1); fk.setName("Frank");
		 */
		Teacher teacher = new Teacher();
		teacher.setId(2);
		teacher.setName("Frank");
		// teacher.setFk(fk);
		teacher.setAge(21);
		session.save(teacher);

		// ----------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
