package com.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImp implements UserDao {

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	public void add(User user) {
		ValueOperations<String, User> valueOper = redisTemplate.opsForValue();
		valueOper.set(user.getId(), user);
	}

	public String get(String id) {
		return null;
	}
}
