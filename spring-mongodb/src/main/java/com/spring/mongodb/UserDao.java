package com.spring.mongodb;

import java.util.List;

public interface UserDao {
	public void insert(User user); 
    public User findOne(String id);   
    public List<User> findAll();   
    public List<User> findByRegex(String regex);
    public void removeOne(String id);   
    public void removeAll();   
    public void findAndModify(String id);   
}
