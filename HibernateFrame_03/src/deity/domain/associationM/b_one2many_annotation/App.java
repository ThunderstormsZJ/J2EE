package deity.domain.associationM.b_one2many_annotation;

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
		Configuration configuration = new Configuration()//
				.configure("hibernate_b.cfg.xml");
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

		Department department = new Department().setName("dept4");
		Employee employee1 = new Employee().setName("emp3");
		Employee employee2 = new Employee().setName("emp4");
		Employee employee3 = new Employee().setName("emp5");

		/*
		 * 多对一的单项只需设置一向
		 */
		department.getEmployees().add(employee1);
		department.getEmployees().add(employee2);
		department.getEmployees().add(employee3);
		employee1.setDepartment(department);
		employee2.setDepartment(department);
		employee3.setDepartment(department);

		// 顺序反过来之后会多一条update语句
		// session.save(department);
		/*
		 * 设置cascade=CascadeType.ALL 可以关联的保存
		 */
		session.save(department);
		// session.save(employee1)
		// session.save(employee2)
		// session.save(employee3)

		// ------------------------------------
		session.getTransaction().commit();
	}

	@Test
	public void testGet() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		/*
		 * 默认的fetch=eager
		 */
		Employee emp = (Employee) session.get(Employee.class, 2);
		System.out.println(emp);

		/*
		 * 默认的fetch=lazy
		 */
		Department dept = (Department) session.get(Department.class, 2);
		System.out.println(dept);
		// 在用到时才会加载
		System.out.println(dept.getEmployees());

		// ------------------------------------
		session.getTransaction().commit();
	}

	@Test
	public void testDelete() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		Employee emp = new Employee();
		emp.setId(2);
		session.delete(emp);
		
		Department dept = new Department();
		dept.setId(2);
		session.delete(dept);
		
		// ------------------------------------
		session.getTransaction().commit();
	}

	@Test
	public void testUpdate() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		Employee emp = (Employee) session.get(Employee.class, 5);
		//Department dept = (Department) session.get(Department.class, 1);
		
		//Employee emp1 = new Employee().setName("emp5");
		//dept.getEmployees().add(emp1);
		//emp1.setDepartment(dept);
		//emp.setDepartment(dept);
		emp.setName("emp5");
		emp.getDepartment().setName("dept3");
		session.update(emp);
		
		// ------------------------------------
		session.getTransaction().commit();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		sessionFactory.close();
	}
}
