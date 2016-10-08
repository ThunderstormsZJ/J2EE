package deity.domain.associationM.e_tree;

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

		Org o = new Org();
		o.setName("总公司");
		Org o1 = new Org();
		o1.setName("分公司1");
		Org o2 = new Org();
		o2.setName("分公司2");
		Org o11 = new Org();
		o11.setName("分公司11");
		Org o12 = new Org();
		o12.setName("分公司21");
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.setParent(o);
		o2.setParent(o);
		o1.getChildren().add(o11);
		o2.getChildren().add(o12);
		o11.setParent(o1);
		o12.setParent(o2);

		session.save(o);

		// ------------------------------------
		session.getTransaction().commit();
	}

	@Test
	public void testGet() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ------------------------------------

		Org org = (Org) session.get(Org.class, 1);
		print(org,0);
		
		// ------------------------------------
		session.getTransaction().commit();
	}
	
	private void print(Org org,int level){
		String preStr = "";
		for (int i = 0; i < level; i++) {
			preStr +="---";
		}
		System.out.println(preStr+org);
		for(Org child:org.getChildren()){
			print(child,level+1);
		}
	}

	@AfterClass
	public static void afterClass() throws Exception {
		sessionFactory.close();
	}
}
