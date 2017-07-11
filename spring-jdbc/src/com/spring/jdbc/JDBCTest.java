package com.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
	
	{
			ctx = new ClassPathXmlApplicationContext("hello-jdbc.xml");
			jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
			namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}
	
	/**
	 * jdbcTemplate
	 */
	@Test
	public void testUpdate() {
		String sql = "UPDATE user SET name = ? WHERE id = 1";
		jdbcTemplate.update(sql, "vivi");
	}
	
	@Test
	public void batchInsert() {
		String sql = "INSERT INTO user(id, name, age) VALUES(?, ?, ?)";
		
		List<Object[]> batchArgs = new ArrayList<>();
		
		batchArgs.add(new Object[]{4, "A", 20});
		batchArgs.add(new Object[]{5, "B", 30});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	@Test
	public void MulQuery() {
		String sql = "SELECT id, name, age FROM user WHERE id > ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		List<User> users = jdbcTemplate.query(sql, rowMapper, 1);
		System.out.println(users);
	}
	
	@Test
	public void SingleQuery() {
		String sql = "SELECT id, name NAME, age c FROM user WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(user);
	}
	
	@Test
	public void SingleQuery2() {
		String sql = "SELECT COUNT(*) FROM user WHERE id < ?";
		long count = jdbcTemplate.queryForObject(sql, long.class, 5);
		System.out.println(count);
	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	/**
	 * namedParameterJdbcTemplate
	 */
	@Test
	public void testNamedParameterJdbcTemplate() {
		String sql = "INSERT INTO user(id, name, age) VALUES(:id, :name, :age)";
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("id", 8);
		paramMap.put("name", "vivi");
		paramMap.put("age", 22);
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Test
	public void testNamedParameterJdbcTemplate2() {
		String sql = "INSERT INTO user(id, name, age) VALUES(:id, :name, :age)";
		Map<String, Object> paramMap = new HashMap<>();
		
		User user = new User();
		user.setAge(33);
		user.setId(199);
		user.setName("hello");
		
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
}
