package com.spring.helloworld;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		//��ͳ����
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName(" world");		
		helloWorld.hello();
	
		//spring��򵥷���
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		helloWorld = (HelloWorld) ctx.getBean("helloworld");
		helloWorld.hello();
		
		//spring��p��ǩʹ��
		helloWorld = (HelloWorld) ctx.getBean("hellovivi");
		helloWorld.hello();
		
		//spring���ö���
		Person vivi = (Person) ctx.getBean("vivi");
		System.out.println(vivi);
		
		//spring���캯��
		Person begin = (Person) ctx.getBean("begin");
		System.out.println(begin);
		
		//spring�ڲ�bean
		Person dancesfly = (Person) ctx.getBean("dancesfly");
		System.out.println(dancesfly);
		
		//spring listʹ��
		PersonList viviList = (PersonList) ctx.getBean("viviList");
		System.out.println(viviList);
		
		//spring util-listʹ��
		PersonList viviLists = (PersonList) ctx.getBean("viviLists");
		System.out.println(viviLists);
		
		//spring mapʹ��
		PersonMap viviMap = (PersonMap) ctx.getBean("viviMap");
		System.out.println(viviMap);
		
		//spring properties
		Propertie dataSource = ctx.getBean(Propertie.class);
		System.out.println(dataSource);
		
		//autowire
		System.out.println("************auto**********");
		Person auto = (Person) ctx.getBean("auto");
		System.out.println(auto);
		
		//�̳�
		Person parent = (Person) ctx.getBean("parent");
		System.out.println(parent);
		
		//����
		System.out.println("******depend*******");
		Person depend = (Person) ctx.getBean("depend");
		System.out.println(depend);
		
		//����
		Person depend1 = (Person) ctx.getBean("depend");
		System.out.println(depend == depend1); //����ture
		
		//����
		Person prototype = (Person) ctx.getBean("prototype");
		Person prototype1 = (Person) ctx.getBean("prototype");
		System.out.println(prototype == prototype1); //����false
		
		//����mysql
		DataSource dataSource1 = (DataSource) ctx.getBean("dataSource1");
		System.out.println(dataSource1.getConnection());
		
		//�����ⲿ�ļ��������ݿ�
		DataSource dataSource2 = (DataSource) ctx.getBean("dataSource2");
		System.out.println(dataSource2.getConnection());
		
		//spel
		Car carSpel = (Car) ctx.getBean("carSpel");
		System.out.println(carSpel);
		Car carSpel_math = (Car) ctx.getBean("carSpel_math");
		System.out.println(carSpel_math);
		Car carSpel_wen = (Car) ctx.getBean("carSpel_wen");
		System.out.println(carSpel_wen);
		
		//bean��������
		/**
		 * 1.Contructor
		 * 2.����set����
		 * 3.����postProcessBeforeInitialization
		 * 4.init
		 * 5.����postProcessAfterInitialization
		 * 6.destory
		 */
		Car carRound = (Car) ctx.getBean("carRound");
		System.out.println(carRound);
		
		//��̬��������
		Car staticCar = (Car) ctx.getBean("staticCar");
		System.out.println(staticCar);
		
		//ʵ����������
		Car instanceCar = (Car) ctx.getBean("instanceCar");
		System.out.println(instanceCar);
		
		//factory bean
		Car carFactoryBean = (Car) ctx.getBean("carFactoryBean");
		System.out.println(carFactoryBean);
		
		((AbstractApplicationContext) ctx).close();
		
		/**
		 * ע��
		 * @Component ��ͨ���
		 * @Respository �־ò����
		 * @Service ��������
		 * @Controller ���ֲ����
		 * ����User xml��������user ����ͨ��value��ָ�����ƣ����磺@Service("userAbc")
		 * ���Ի���
		 */
		ApplicationContext ctxAnn = new ClassPathXmlApplicationContext("applicationContext.xml");
		CarAnnotationTest carAnnotation = (CarAnnotationTest) ctxAnn.getBean("carAnnotationTest");
		carAnnotation.testAnnotation();
	}
}
