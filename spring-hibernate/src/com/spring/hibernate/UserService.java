package com.spring.hibernate;

public interface UserService {
	public void updateName(Integer id, String name);
	public String getName(Integer id);
}
