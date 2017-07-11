package com.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Car implements CarInterface {
	String bond;
	int speed;
	
	public String getBond() {
		return bond;
	}
	
	public void setBond(String bond) {
		this.bond = bond;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Car(String bond, int speed) {
		super();
		this.bond = bond;
		this.speed = speed;
	}
	
	public Car() {}

	@Override
	public String toString() {
		return "Car [bond=" + bond + ", speed=" + speed + "]";
	}

	@Override
	public int div(int i, int j) {
		return i/j;
	}
}
