package deity.domain.dao;

import org.springframework.stereotype.Component;
import deity.domain.domain.User;
import deity.domain.idao.IUserDao;

@Component
public class UserDao implements IUserDao {
	public void add(User user) {
		System.out.println("add user!"+user.getName());
	}
	
	public void delete(User user) {
		System.out.println("add user!"+user.getName());
	}
}
