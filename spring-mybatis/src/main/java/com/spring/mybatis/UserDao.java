package com.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.UserMapper;

@Service
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public void add() {
		System.out.println(userMapper);
		User user = new User();
		user.setAge(10);
		user.setId(200);
		user.setName("hello");
		
		userMapper.insert(user);
	}
}
