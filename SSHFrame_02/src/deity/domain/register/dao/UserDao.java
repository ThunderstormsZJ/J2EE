package deity.domain.register.dao;

import java.util.List;
import deity.domain.register.model.User;

public  interface UserDao {
	public List<User> getByName(String username);
	public void save(User user);
	public List<User> listAll();
	public User load(int id);
}
