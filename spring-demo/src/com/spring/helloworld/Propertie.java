package com.spring.helloworld;

import java.util.Properties;

public class Propertie {
	Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Propertie(Properties properties) {
		super();
		this.properties = properties;
	}

	public Propertie() {
		super();
	}

	@Override
	public String toString() {
		return "Propertie [properties=" + properties + "]";
	}
}
