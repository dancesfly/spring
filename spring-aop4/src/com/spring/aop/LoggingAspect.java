package com.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(public Integer com.spring.aop.Car.div(Integer, Integer))")
	public void declareJoinPointExpression(){}
	
	@Around(value="declareJoinPointExpression()")
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
