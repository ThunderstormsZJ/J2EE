package deity.domain.idao;

import java.util.List;

import deity.domain.domain.User;

public interface IUserDao {
	public void add(User user);
	public void delete(User user);
	public List<User> findAll();
}
