package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("hello-aop2.xml");

		CarInterface carAop = ctx.getBean(CarInterface.class);
		Integer reslut = null;
		reslut = carAop.div(100, 1);
		System.out.println("reslut " + reslut);
		
		((AbstractApplicationContext) ctx).close();
	}
}
