package com.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(public int com.spring.aop.Car.div(int, int))")
	public void declareJoinPointExpression(){}
	
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("before the method " + methodName + " begin withs " + args);
	}
	
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("after the method " + methodName + " begin withs " + args);
	}
	
	@AfterReturning(value="declareJoinPointExpression()",returning="reslut")
	public void afterReturnMethod(JoinPoint joinPoint, Object reslut) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("afterReturn the method " + methodName + " begin withs " + args + " reslut " + reslut);
	}
	
	@AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
	public void afterThrowMethod(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("AfterThrowing the method " + methodName + " begin withs " + args + "exception " + ex);
	}
}
