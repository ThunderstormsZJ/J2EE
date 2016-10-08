package com.deity.oa.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import com.deity.oa.basic.impl.BasicDaoImpl;
import com.deity.oa.model.User;
import com.deity.oa.service.UserService;

@Component
public class UserServiceImpl extends BasicDaoImpl<User> implements UserService{
	//实现根据用户名查询用户
	public User findByLoginName(String loginName) {
		return (User) getSession()//
				.createQuery("from User u where u.loginName=?")//
				.setParameter(0, loginName)//
				.uniqueResult();
	}
	//验证用户的登录密码和登录名
	public User checkUser(User model) {
		return (User) getSession()//
		.createQuery("from User u where u.loginName=? and u.password=?")//
		.setParameter(0, model.getLoginName())//
		.setParameter(1, DigestUtils.md5DigestAsHex(model.getPassword().getBytes()))//
		.uniqueResult();
	}
}
