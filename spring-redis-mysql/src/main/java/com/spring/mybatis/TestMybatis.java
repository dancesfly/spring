package com.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatis {
	
	public static void main(String[] args) {		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:hello-redis-mysql.xml");
		UserMysql userMysql = (UserMysql) ctx.getBean(UserMysql.class);
		userMysql.add();
		
		UserRedis userRedis = (UserRedis) ctx.getBean(UserRedis.class);
		userRedis.add();
		
		((AbstractApplicationContext) ctx).close();
	}
}
