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
		 * 	得到的都是新的Session对象
		 * 	需要使用close来关闭
		 * getCurrentSession()
		 * 	得到的上下文的Session的对象，如果没有就创建新的
		 * 	不需要关闭，在commit之后会自动关闭
		 * 	需要配置XML中的hibernate.Current_Session_Context_Class属性
		 * 		其中有thread、jta、等
		 */
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//-------------------------------------------
		
		/*
		 * save()
		 * 	由Transient--->Persisent状态
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
		//student 为 transient态
		//session.save(student);
		//student 为 persisent态
		
		/*
		 * delete()
		 * 	由Persisent--->Transient状态
		 * 	由Detached--->Transient状态
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
		 * 	由Detached--->Persisent状态
		 * 	由Transient--->Persisent状态
		 */
		Student student = new Student();
		student.setId(3);
		student.setName("Jack");
		session.update(student);
		
		//在事务提交之后会同步数据库和session缓存
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
		//执行保存
		session.saveOrUpdate(student);
		System.out.println("---");
		
		//-------------------------------------------
		session.getTransaction().commit();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		student.setName("Jession");
		//执行更新
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
		 * 	返回是一个代理对象，只有在用到该对象的内容时才会发送sql语句
		 * get
		 * 	在执行该方法就会立即发送sql语句
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
