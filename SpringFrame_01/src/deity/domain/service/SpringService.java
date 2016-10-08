package deity.domain.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import deity.domain.domain.User;
import deity.domain.idao.IUserDao;

@Component
public class SpringService {
	private IUserDao userDao;
	public void addUser(){
		User user = new User();
		user.setName("tiandao");
		userDao.add(user);
	}
	public void deleteUser(){
		User user = new User();
		user.setName("tiandao");
		userDao.delete(user);
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
}
