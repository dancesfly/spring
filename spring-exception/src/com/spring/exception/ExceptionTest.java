package com.spring.exception;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ExceptionTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("hello-exception.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
	@Test
	public void SingleQuery() {
		String sql = "SELECT COUNT(*) FROM user WHERE id < ?";
		long count = jdbcTemplate.queryForObject(sql, long.class, 0);
		if(count == 0) {
			throw new UserException("用户不存在");
		}
		System.out.println("用户存在");
	}
}
