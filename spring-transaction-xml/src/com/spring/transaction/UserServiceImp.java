package com.spring.transaction;

public class UserServiceImp implements UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void updateName(Integer id, String name) {
		userDao.updateName(id, name);
	}
	
	@Override
	public String getName(Integer id) {
		return userDao.getName(id);
	}
}
