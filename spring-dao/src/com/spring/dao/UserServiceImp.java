package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void findName(Integer id) {
		String name = userDao.getName(id);
		System.out.println(name);
	}
}
