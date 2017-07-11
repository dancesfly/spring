package com.spring.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CarAnnotationTest {
	public CarAnnotationTest() {}
	
	@Autowired
	//@Qualifier("car2")
	private CarAnnotation2Test carabc;
	
	public void testAnnotation() {
		System.out.println(carabc+"testAnnotation");
	}
}
