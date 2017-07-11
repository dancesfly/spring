package com.spring.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDao {

	private ApplicationContext ctx = null;
	private UserService userService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("hello-dao.xml");
		userService = ctx.getBean(UserService.class);
	}
	
	@Test
	public void test() {
		userService.findName(1);
	}
}
