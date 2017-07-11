package com.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserRedis {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public void add() {
		ValueOperations<String, String> valueOper = redisTemplate.opsForValue();
		valueOper.set("1", "hello");
	}
}
