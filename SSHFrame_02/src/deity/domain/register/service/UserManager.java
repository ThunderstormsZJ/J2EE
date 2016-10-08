package deity.domain.register.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import deity.domain.register.dao.UserDao;
import deity.domain.register.model.User;

@Component
public class UserManager {
	private UserDao userDaoImp;
	//�ж��û��Ƿ����
	public boolean exists(String username){
		List<User> user = userDaoImp.getByName(username);
		if(user!=null&&user.size()>0) return true;
		return false;
	}
	//����û�
	public String add(User user){
		if(!this.exists(user.getUsername())){
			userDaoImp.save(user);
			return "success";
		}
		return "fail";
	}
	//�г������û�
	public List<User> listALl() {
		return userDaoImp.listAll();
	}
	//��ϸ��ϸ
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
