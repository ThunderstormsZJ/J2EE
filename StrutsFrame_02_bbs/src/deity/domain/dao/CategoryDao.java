package deity.domain.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import deity.domain.domain.*;

public class CategoryDao {
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
				.applySettings(configuration.getProperties())//
				.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public List<Category> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// ---------------------------------------

		List<Category> categorys = session.createQuery("From Category").list();

		// ---------------------------------------
		session.getTransaction().commit();
		return categorys;
	}
}
