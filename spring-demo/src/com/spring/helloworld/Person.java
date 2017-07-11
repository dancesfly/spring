package com.spring.helloworld;

public class Person {
	
	int age;
	String name;
	Car car;
	
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
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", car=" + car + "]";
	}

	public Person(int age, String name, Car car) {
		super();
		this.age = age;
		this.name = name;
		this.car = car;
	}
	
	public Person() {}
}
