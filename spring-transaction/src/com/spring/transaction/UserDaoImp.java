package com.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String getName(Integer id) {
		String name = null;
		String sql = "SELECT name FROM user WHERE ID = ?";
		
		try {
			name = jdbcTemplate.queryForObject(sql, String.class, id);
		} catch (Exception e) {
			throw new UserException("用户不存在");
		}
		
		return name;
	}

	@Override
	public void updateName(Integer id, String name) {
		String sql = "UPDATE user SET NAME = ? WHERE ID = ?";
		jdbcTemplate.update(sql, name, id);
	}
}
