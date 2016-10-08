package deity.domain.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import deity.domain.domain.Log;
import deity.domain.domain.User;
import deity.domain.idao.ILogDao;
import deity.domain.idao.IUserDao;

@Component
public class UserService {
	private IUserDao userDao;
	private ILogDao logDao;
	
	//@Transactional
	public void addUser(User user){
		Log log = new Log();
		log.setMessage(user.getName()+"start");
		logDao.add(log);
		userDao.add(user);
	}
	public List<User> findAll(){
		return userDao.findAll();
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
	public ILogDao getLogDao() {
		return logDao;
	}
	@Resource
	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}
	
}
