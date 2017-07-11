package com.spring.redis;

public interface UserDao {
	public void add(User user);
	public String get(String id);
}
