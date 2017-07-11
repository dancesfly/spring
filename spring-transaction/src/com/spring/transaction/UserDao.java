package com.spring.transaction;

public interface UserDao {
	public String getName(Integer id);
	public void updateName(Integer id, String name);
}
