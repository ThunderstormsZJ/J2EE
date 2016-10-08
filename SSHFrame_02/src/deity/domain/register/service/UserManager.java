package deity.domain.register.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import deity.domain.register.dao.UserDao;
import deity.domain.register.model.User;

@Component
public class UserManager {
	private UserDao userDaoImp;
	//判断用户是否存在
	public boolean exists(String username){
		List<User> user = userDaoImp.getByName(username);
		if(user!=null&&user.size()>0) return true;
		return false;
	}
	//添加用户
	public String add(User user){
		if(!this.exists(user.getUsername())){
			userDaoImp.save(user);
			return "success";
		}
		return "fail";
	}
	//列出所有用户
	public List<User> listALl() {
		return userDaoImp.listAll();
	}
	//详细详细
	public User detail(int id) {
		return userDaoImp.load(id);
	}
	
	public UserDao getUserDaoImp() {
		return userDaoImp;
	}
	@Resource
	public void setUserDaoImp(UserDao userDaoImp) {
		this.userDaoImp = userDaoImp;
	}
	
}
