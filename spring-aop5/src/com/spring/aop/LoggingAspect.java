package com.spring.aop;

import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public void aRoundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		Object reslut = null;
		
		System.out.println("before");
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("aRoundMethod the method " + methodName + " begin withs " + args);
		
		try {
			reslut = joinPoint.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("after");
		System.out.println("reslut " + reslut);
	}
}
