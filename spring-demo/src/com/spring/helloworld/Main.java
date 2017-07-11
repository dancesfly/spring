package com.spring.helloworld;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		//传统方法
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName(" world");		
		helloWorld.hello();
	
		//spring最简单方法
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		helloWorld = (HelloWorld) ctx.getBean("helloworld");
		helloWorld.hello();
		
		//spring中p标签使用
		helloWorld = (HelloWorld) ctx.getBean("hellovivi");
		helloWorld.hello();
		
		//spring引用对象
		Person vivi = (Person) ctx.getBean("vivi");
		System.out.println(vivi);
		
		//spring构造函数
		Person begin = (Person) ctx.getBean("begin");
		System.out.println(begin);
		
		//spring内部bean
		Person dancesfly = (Person) ctx.getBean("dancesfly");
		System.out.println(dancesfly);
		
		//spring list使用
		PersonList viviList = (PersonList) ctx.getBean("viviList");
		System.out.println(viviList);
		
		//spring util-list使用
		PersonList viviLists = (PersonList) ctx.getBean("viviLists");
		System.out.println(viviLists);
		
		//spring map使用
		PersonMap viviMap = (PersonMap) ctx.getBean("viviMap");
		System.out.println(viviMap);
		
		//spring properties
		Propertie dataSource = ctx.getBean(Propertie.class);
		System.out.println(dataSource);
		
		//autowire
		System.out.println("************auto**********");
		Person auto = (Person) ctx.getBean("auto");
		System.out.println(auto);
		
		//继承
		Person parent = (Person) ctx.getBean("parent");
		System.out.println(parent);
		
		//依赖
		System.out.println("******depend*******");
		Person depend = (Person) ctx.getBean("depend");
		System.out.println(depend);
		
		//单例
		Person depend1 = (Person) ctx.getBean("depend");
		System.out.println(depend == depend1); //返回ture
		
		//多例
		Person prototype = (Person) ctx.getBean("prototype");
		Person prototype1 = (Person) ctx.getBean("prototype");
		System.out.println(prototype == prototype1); //返回false
		
		//连接mysql
		DataSource dataSource1 = (DataSource) ctx.getBean("dataSource1");
		System.out.println(dataSource1.getConnection());
		
		//引用外部文件连接数据库
		DataSource dataSource2 = (DataSource) ctx.getBean("dataSource2");
		System.out.println(dataSource2.getConnection());
		
		//spel
		Car carSpel = (Car) ctx.getBean("carSpel");
		System.out.println(carSpel);
		Car carSpel_math = (Car) ctx.getBean("carSpel_math");
		System.out.println(carSpel_math);
		Car carSpel_wen = (Car) ctx.getBean("carSpel_wen");
		System.out.println(carSpel_wen);
		
		//bean生命周期
		/**
		 * 1.Contructor
		 * 2.调用set方法
		 * 3.调用postProcessBeforeInitialization
		 * 4.init
		 * 5.调用postProcessAfterInitialization
		 * 6.destory
		 */
		Car carRound = (Car) ctx.getBean("carRound");
		System.out.println(carRound);
		
		//静态工厂方法
		Car staticCar = (Car) ctx.getBean("staticCar");
		System.out.println(staticCar);
		
		//实例工厂方法
		Car instanceCar = (Car) ctx.getBean("instanceCar");
		System.out.println(instanceCar);
		
		//factory bean
		Car carFactoryBean = (Car) ctx.getBean("carFactoryBean");
		System.out.println(carFactoryBean);
		
		((AbstractApplicationContext) ctx).close();
		
		/**
		 * 注解
		 * @Component 普通组件
		 * @Respository 持久层组件
		 * @Service 服务层组件
		 * @Controller 表现层组件
		 * 类名User xml配置名是user 可以通过value来指定名称，例如：@Service("userAbc")
		 * 可以混用
		 */
		ApplicationContext ctxAnn = new ClassPathXmlApplicationContext("applicationContext.xml");
		CarAnnotationTest carAnnotation = (CarAnnotationTest) ctxAnn.getBean("carAnnotationTest");
		carAnnotation.testAnnotation();
	}
}
