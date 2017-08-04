package com.spring.proxy;

public class Main {
	public static void main(String[] args) {
		CarInterface target = new Car();
		CarInterface proxy = new CarProxy(target).getProxy();
		proxy.hello("vivi");
		proxy.div(100, 1);
	}
}
