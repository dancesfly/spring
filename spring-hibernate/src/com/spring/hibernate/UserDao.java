package com.spring.hibernate;

public interface UserDao {
	public String getName(Integer id);
	public void updateName(Integer id, String name);
}
