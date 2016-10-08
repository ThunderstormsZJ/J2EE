package deity.domain.dao;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import deity.domain.domain.User;
import deity.domain.idao.IUserDao;

@Component
public class UserDao implements IUserDao {
	private HibernateTemplate hibernateTemplate;
	
	public void add(User user) {
		hibernateTemplate.save(user);
	}
	public void delete(User user) {
		System.out.println("add user!"+user.getName());
	}
	public List<User> findAll() {
		List<User> users = (List<User>) hibernateTemplate.find("from User");
		return users;
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
