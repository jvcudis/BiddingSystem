package org.fpt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.fpt.aspect.annotations.PerfLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
@Aspect
@Component
public class PerfLoggingAspect {
 
	private static final Logger logger  = LoggerFactory.getLogger(PerfLoggingAspect.class);
	
	private static String[] LEVEL = {"DEBUG","ERROR","FATAL","INFO","TRACE","WARN"};
	
	@Pointcut("execution(@org.fpt.aspect.annotations.PerfLog * *.*(..))")
	public void performanceTargets() { }
	
	@Before("performanceTargets()")
	public void beforeExecution(JoinPoint joinPoint) {
		
		Class<? extends Object> clazz = joinPoint.getTarget().getClass();
		String name = joinPoint.getSignature().getName();
		
		if(!joinPoint.getArgs().getClass().isArray()) {
			logger.info(String.format("[%s] [ entering < %s >]", LEVEL[3], name));
		} else {
			logger.info(String.format("[%s] [ entering < %s > with params %s]", LEVEL[3], name, constructArgsString(clazz, joinPoint.getArgs())));
		}
	}
	
//	@AfterReturning(value = "@annotation(perfLog)", returning = "returnValue", argNames = "joinPoint, perfLog, returnValue")
	@After(value = "performanceTargets()")
	public void afterExecution(JoinPoint joinPoint) {
		
		Class<? extends Object> clazz = joinPoint.getTarget().getClass();
		String name = joinPoint.getSignature().getName();
		
		if (joinPoint.getSignature() instanceof MethodSignature) {
			MethodSignature signature = (MethodSignature) joinPoint.getSignature();
			String returnName = signature.getReturnType().getName();
			
			if(returnName.compareTo("void") == 0) {
				logger.info(String.format("[%s] [ leaving < %s >]", LEVEL[3], name));
			} 
			return;
		}
		
		logger.info(String.format("[%s] [ leaving < %s > with return value %s]", LEVEL[3], name, constructArgsString(clazz, 0)));
	}
	
//	@Around("performanceTargets()")
//	public Object logPerformance(ProceedingJoinPoint joinPoint) {
//		try {
//			long start = System.nanoTime();
//			Object result = joinPoint.proceed();
//			long end = System.nanoTime();
//			
//			String name = joinPoint.getSignature().getName();
//			
//			logger.info(String.format("[%s] [ < %s > took %d ns execution time ]", LEVEL[3], name, (end - start)));
//			
//			return result;
//		} catch(Throwable e) {
//			throw new RuntimeException(e);
//		}
//	}
			
	private String constructArgsString(Class<?> clazz, Object... arguments) {

		StringBuffer buffer = new StringBuffer();
		for (Object object : arguments) {

			buffer.append(object);
		}
		
		return buffer.toString();
	}
}