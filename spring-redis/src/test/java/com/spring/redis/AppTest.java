package com.spring.redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	
	private ApplicationContext ctx = null;
	private UserDao userDao = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("classpath:hello-redis.xml");
		userDao = (UserDao)ctx.getBean("userDao");
	}
	
	@Test
    public void test()
    {
		User user = new User();
		user.setId("1");
		userDao.add(user);
    }
}
