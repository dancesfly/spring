package com.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatis {
	
	public static void main(String[] args) {		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:hello-mybatis.xml");
		UserDao userDao = (UserDao) ctx.getBean(UserDao.class);
		System.out.println(userDao.group(10));
		
		((AbstractApplicationContext) ctx).close();
	}
}
