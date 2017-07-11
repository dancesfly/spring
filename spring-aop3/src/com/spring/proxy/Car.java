package com.spring.proxy;

import org.springframework.stereotype.Component;

@Component
public class Car implements CarInterface {
	String bond;
	int speed;
	
	public Car() {} 

	public Car(String bond, int speed) {
		super();
		System.out.println("Car Contructor");
		this.bond = bond;
		this.speed = speed;
	}

	public String getBond() {
		return bond;
	}
	
	public void setBond(String bond) {
		System.out.println("setBond");
		this.bond = bond;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		System.out.println("setSpeed");
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [bond=" + bond + ", speed=" + speed + "]";
	}

	@Override
	public Integer div(Integer i, Integer j) {
		return i / j;
	}

	@Override
	public void hello(String name) {
		System.out.println("hello " + name);
	}
}
