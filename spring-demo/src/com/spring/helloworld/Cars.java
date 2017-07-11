package com.spring.helloworld;

import java.util.HashMap;
import java.util.Map;

public class Cars {
	private static Map<String, Car> cars = new HashMap<String, Car>();
	
	static {		
		cars.put("vivicar", new Car("vivicar", 1000));
		cars.put("begincar", new Car("begincar", 2000));
	} 
	
	public static Car getCar(String name) {
		return cars.get(name);
	}

	@Override
	public String toString() {
		return "Cars [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
