package deity.domain.coreAPI;

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
	private static SessionFactory sessionFactory= null;
	@BeforeClass
	public static void beforeClass() throws Exception {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
				.applySettings(configuration.getProperties())//
				.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	@Test
	public void testSave() throws Exception {
		/*
		 * openSession()
		 * 	�õ��Ķ����µ�Session����
		 * 	��Ҫʹ��close���ر�
		 * getCurrentSession()
		 * 	�õ��������ĵ�Session�Ķ������û�оʹ����µ�
		 * 	����Ҫ�رգ���commit֮����Զ��ر�
		 * 	��Ҫ����XML�е�hibernate.Current_Session_Context_Class����
		 * 		������thread��jta����
		 */
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//-------------------------------------------
		
		/*
		 * save()
		 * 	��Transient--->Persisent״̬
		 */
		Student student = new Student();
		student.setName("Frank");
		student.setBirthday(new Date());
		session.save(student);
		
		//-------------------------------------------
		session.getTransaction().commit();
		System.out.println(student.getId());
		
	}
	@Test
	public void testDelete() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//-------------------------------------------
		
		Student student = new Student();
		//student.setName("Jack");
		//student.setBirthday(new Date());
		//student Ϊ transient̬
		//session.save(student);
		//student Ϊ persisent̬
		
		/*
		 * delete()
		 * 	��Persisent--->Transient״̬
		 * 	��Detached--->Transient״̬
		 */
		//session.delete(student);
		
		student.setId(1);
		session.delete(student);
		
		//-------------------------------------------
		session.getTransaction().commit();
		System.out.println(student.getId());
	}
	
	@Test
	public void testUpdate() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//-------------------------------------------
		
		/*
		 * save()
		 * 	��Detached--->Persisent״̬
		 * 	��Transient--->Persisent״̬
		 */
		Student student = new Student();
		student.setId(3);
		student.setName("Jack");
		session.update(student);
		
		//�������ύ֮���ͬ�����ݿ��session����
		student.setBirthday(new Date());
		System.out.println("---");
		
		//-------------------------------------------
		session.getTransaction().commit();
		System.out.println(student.getId());
	}
	
	@Test
	public void testSaveOrUpdate() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//-------------------------------------------
		
		Student student = new Student();
		student.setName("Session");
		student.setBirthday(new Date());
		//ִ�б���
		session.saveOrUpdate(student);
		System.out.println("---");
		
		//-------------------------------------------
		session.getTransaction().commit();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		student.setName("Jession");
		//ִ�и���
		session.saveOrUpdate(student);
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testGetOrLoad() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//-------------------------------------------
		
		/*
		 * load
		 * 	������һ���������ֻ�����õ��ö��������ʱ�Żᷢ��sql���
		 * get
		 * 	��ִ�и÷����ͻ���������sql���
		 */
		//Student student = (Student) session.get(Student.class, 3);
		Student student = (Student) session.load(Student.class, 3);
		
		System.out.println("---");
		System.out.println(student.getName());
		
		
		//-------------------------------------------
		session.getTransaction().commit();
		System.out.println(student.getName());
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		sessionFactory.close();
	}
}
