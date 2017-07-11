package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String getName(Integer id) {
		String sql = "SELECT name FROM user WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}
}
