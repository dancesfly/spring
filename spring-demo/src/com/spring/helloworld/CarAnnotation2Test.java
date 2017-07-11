package com.spring.helloworld;

import org.springframework.stereotype.Service;

@Service("car2")
//@Service
public class CarAnnotation2Test {
	public CarAnnotation2Test() {}
	
	public void testAnnotation() {
		System.out.println("ddtestAnnotation");
	}
}
