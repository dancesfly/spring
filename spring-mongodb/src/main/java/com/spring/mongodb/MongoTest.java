package com.spring.mongodb;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MongoTest {
	
	private static Log log = LogFactory.getLog(MongoTest.class.getName());
	private UserDao userDao = null;
	
	public void init(){
		log.debug("init success");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:hello-mongodb.xml");
		userDao = (UserDao)ctx.getBean("userDao");
	}
	
	public void insert(){
		User user = new User("cuiran",27);
		userDao.insert(user);
		System.out.println("insert");
		log.debug("insert success");
	}
	
	public void findOne(){
		String id = "5909a72cc19c42219cc6e908";
		User user = userDao.findOne(id);
		System.out.println(user);
		log.debug(user);
	}
	
	public void listAll(){
		List<User> users = userDao.findAll();
		log.debug("listAll:");
		for (User user : users){
			System.out.println(user.toString());
			log.debug(user.toString());
		}
	}
	
	public void start(){
		init();
		//insert();
		//listAll();
		findOne();
	}
	
	public static void main(String[] args) {
		MongoTest t=new MongoTest();
		t.start();
	}
}
