package com.spring.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CarAnnotation {
	public CarAnnotation() {}
	
	@Autowired
	@Qualifier("car2")
	private CarAnnotation2Test car2;
	
	public void testAnnotation() {
		System.out.println("abc");
		System.out.println(car2+"testAnnotation");
	}
}
