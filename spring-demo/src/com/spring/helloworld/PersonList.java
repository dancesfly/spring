package com.spring.helloworld;

import java.util.List;

public class PersonList {
	
	int age;
	String name;
	List<Car> car;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", car=" + car + "]";
	}

	public PersonList(int age, String name, List<Car> car) {
		super();
		this.age = age;
		this.name = name;
		this.car = car;
	}
	
	public PersonList() {}
}
