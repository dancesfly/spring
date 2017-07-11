package com.spring.helloworld;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
	String bond;
	
	public void setBond(String bond) {
		this.bond = bond;
	}
	
	@Override
	public Car getObject() throws Exception {
		return new Car(bond, 30000);
	}

	@Override
	public Class getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public String toString() {
		return "CarFactoryBean [bond=" + bond + "]";
	}
}
