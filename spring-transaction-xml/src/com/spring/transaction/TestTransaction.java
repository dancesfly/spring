package com.spring.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransaction {

	private ApplicationContext ctx = null;
	private UserService userService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("hello-transaction-xml.xml");
		userService = ctx.getBean(UserService.class);
	}
	
	@Test
	public void test() {
		userService.updateName(1, "1");
	}
}
