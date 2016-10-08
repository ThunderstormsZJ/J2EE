package deity.domain.b_dao;

import java.util.List;
import org.junit.Test;
import deity.domain.a_helloworld.User;

public class UserDaoTest {
	private UserDao userDao = new UserDao();
	// 保存用户
	@Test
	public void testSave() throws Exception {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("Jack"+i);
			userDao.saveUser(user);
		}
	}
	// 更新用户
	@Test
	public void testUpdate() throws Exception {
		User user = userDao.findUserById(1);
		user.setName("Jack");
		userDao.updateUser(user);
	}
	// 删除指定用户
	@Test
	public void testDelete() throws Exception {
		userDao.deleteUserById(2);
	}
	// 根据id查询用户
	@Test
	public void testFindById() throws Exception {
		User user = userDao.findUserById(3);
		System.out.println(user);
	}
	// 查询所有的用户
	@Test
	public void testFindAll() throws Exception {
		List<User> userList = userDao.findAllUser();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	// 分页查询所有的用户
	@Test
	public void testFindByPage() throws Exception {
		Page<User> page = userDao.findUserByPage(0,5);
		System.out.println("COUNT:"+page.getCount());
		for (User user : page.getList()) {
			System.out.println(user);
		}
	}
}
