package com.spring.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class CarProxy {
	private CarInterface target;
	
	public CarProxy(CarInterface target2) {
		this.target = target2;
	}

	public CarInterface getProxy() {
		CarInterface proxy = null;
		ClassLoader loader = target.getClass().getClassLoader();
		Class [] interfaces = new Class[] {CarInterface.class};

		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("before");
				Object result = method.invoke(target, args);
				System.out.println("after");
				return result;
			}
		};
		
		proxy = (CarInterface) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
