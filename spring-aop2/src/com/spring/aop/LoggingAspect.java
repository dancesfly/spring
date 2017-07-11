package com.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("before the method " + methodName + " begin withs " + args);
	}
	
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("after the method " + methodName + " begin withs " + args);
	}
	
	public void afterReturnMethod(JoinPoint joinPoint, Object reslut) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("afterReturn the method " + methodName + " begin withs " + args + " reslut " + reslut);
	}
	
	public void afterThrowMethod(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("AfterThrowing the method " + methodName + " begin withs " + args + "exception " + ex);
	}
}
