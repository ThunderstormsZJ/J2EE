package deity.domain.register.dao.imp;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import deity.domain.register.dao.UserDao;
import deity.domain.register.model.User;

@Component
public class UserDaoImp implements UserDao {
	private HibernateTemplate hibernateTemplate;
	
	public List<User> getByName(String username) {
		//Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		//List<User> user = (List<User>) session.createQuery("from User u where u.username=?").setString(1, username);
		List<User> user = (List<User>) hibernateTemplate.find("from User u where u.username=?", new Object[]{username});
		return user;
	}
	public void save(User user) {
		hibernateTemplate.save(user);
	}
	public List<User> listAll() {
		return (List<User>) hibernateTemplate.find("from User");
	}
	public User load(int id){
		return hibernateTemplate.load(User.class, id);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
