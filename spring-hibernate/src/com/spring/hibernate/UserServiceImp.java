package com.spring.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void updateName(Integer id, String name) {
		userDao.updateName(id, name);
	}
	
	@Override
	public String getName(Integer id) {
		return userDao.getName(id);
	}
}
