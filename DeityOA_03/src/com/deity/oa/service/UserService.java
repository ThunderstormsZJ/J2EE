package com.deity.oa.service;

import com.deity.oa.basic.BasicDao;
import com.deity.oa.model.User;

public interface UserService extends BasicDao<User>{
	/**根据用户名查找用户*/
	User findByLoginName(String loginName);
	/**判断登录信息*/
	User checkUser(User model);
}
