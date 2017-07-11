package com.spring.helloworld;
import java.util.Map;

public class PersonMap {
	
	int age;
	String name;
	Map<String,Car> car;
	
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

	public Map<String,Car> getCar() {
		return car;
	}

	public void setCar(Map<String,Car> car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", car=" + car + "]";
	}

	public PersonMap(int age, String name, Map<String,Car> car) {
		super();
		this.age = age;
		this.name = name;
		this.car = car;
	}
	
	public PersonMap() {}
}
