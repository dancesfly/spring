package com.spring.hibernate;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {

	private ApplicationContext ctx = null;
	private DataSource dataSource = null;
	private UserService userService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("hello-hibernate.xml");
		dataSource = ctx.getBean(DataSource.class);
		userService = ctx.getBean(UserService.class);
	}
	
	@Test
	public void test() throws SQLException {
		//System.out.println(dataSource.getConnection());
		System.out.println(userService.getName(1));
	}
}
