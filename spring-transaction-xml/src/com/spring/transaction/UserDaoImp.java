package com.spring.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImp implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
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
		int count = 0;
		String sql = "UPDATE user SET NAME = ? WHERE ID = ?";
		
		count = jdbcTemplate.update(sql, name, id);
		System.out.println(count);
	}
}
