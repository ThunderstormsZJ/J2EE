package deity.domain.b_dao;

import java.util.List;
import org.junit.Test;
import deity.domain.a_helloworld.User;

public class UserDaoTest {
	private UserDao userDao = new UserDao();
	// �����û�
	@Test
	public void testSave() throws Exception {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("Jack"+i);
			userDao.saveUser(user);
		}
	}
	// �����û�
	@Test
	public void testUpdate() throws Exception {
		User user = userDao.findUserById(1);
		user.setName("Jack");
		userDao.updateUser(user);
	}
	// ɾ��ָ���û�
	@Test
	public void testDelete() throws Exception {
		userDao.deleteUserById(2);
	}
	// ����id��ѯ�û�
	@Test
	public void testFindById() throws Exception {
		User user = userDao.findUserById(3);
		System.out.println(user);
	}
	// ��ѯ���е��û�
	@Test
	public void testFindAll() throws Exception {
		List<User> userList = userDao.findAllUser();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	// ��ҳ��ѯ���е��û�
	@Test
	public void testFindByPage() throws Exception {
		Page<User> page = userDao.findUserByPage(0,5);
		System.out.println("COUNT:"+page.getCount());
		for (User user : page.getList()) {
			System.out.println(user);
		}
	}
}
