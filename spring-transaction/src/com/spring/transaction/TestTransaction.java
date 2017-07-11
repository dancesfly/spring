package com.spring.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class TestTransaction {

	private ApplicationContext ctx = null;
	private UserService userService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("hello-transaction.xml");
		userService = ctx.getBean(UserService.class);
	}
	
	@Transactional
	@Test
	public void test() {
		userService.updateName(9999, "1");
	}
}
