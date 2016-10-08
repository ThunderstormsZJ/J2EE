package deity.domain.b_dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import deity.domain.a_helloworld.User;

public class UserDao {
	private static SessionFactory sessionFactory = null;
	static {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
				.applySettings(configuration.getProperties())//
				.build();
		sessionFactory = configuration//
				.addClass(User.class)//
				.buildSessionFactory(serviceRegistry);
	}

	// �����û�
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			// -------------------------------

			session.save(user);

			// -------------------------------
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// �����û�
	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			// -------------------------------

			session.update(user);

			// -------------------------------
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// ɾ��ָ���û�
	public void deleteUserById(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			// -------------------------------

			Object user = session.get(User.class, id);
			session.delete(user);

			// -------------------------------
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// ����id��ѯ�û�
	public User findUserById(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			// -------------------------------

			User user = (User) session.get(User.class, id);

			// -------------------------------
			session.getTransaction().commit();
			return user;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
	}

	// ��ѯ���е��û�
	public List<User> findAllUser() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			// -------------------------------

			@SuppressWarnings("unchecked")
			List<User> userList = session.createQuery("FROM User").list();

			// -------------------------------
			session.getTransaction().commit();
			return userList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
	}

	// ��ҳ��ѯ���е��û�
	public Page<User> findUserByPage(int firstResult, int maxResult) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			// -------------------------------

			Long count = (Long) session.createQuery("SELECT COUNT(*) FROM User")//
					.uniqueResult();

			@SuppressWarnings("unchecked")
			List<User> userList = session.createQuery("FROM User")//
					.setFirstResult(firstResult)//
					.setMaxResults(maxResult)//
					.list();
			
			// -------------------------------
			session.getTransaction().commit();
			return new Page<User>(count,userList);
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
	}
}
