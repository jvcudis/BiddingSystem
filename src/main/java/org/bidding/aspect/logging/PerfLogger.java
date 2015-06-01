package org.bidding.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
@Aspect
@Component
public class PerfLogger {
 
	protected Logger logger;
	
	// TODO: Convert LEVEL to enum laterz
	private static String[] LEVEL = {"DEBUG","ERROR","FATAL","INFO","TRACE","WARN"};
	private static String DIVIDER = "---------------------------------------------------------------------------------------------";
	
	public PerfLogger() {
		logger = LoggerFactory.getLogger(getClass());
	}
	
	@Pointcut("execution(@org.bidding.aspect.annotations.PerfLog * *.*(..))")
	public void performanceTargets() { }
	
	@Before("performanceTargets()")
	public void beforeExecution(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		logger.info(DIVIDER);
		logger.info(String.format("[%s] [ entering < %s >]", LEVEL[3], signature.getName()));
		logger.info(String.format("[%s] [ SIGNATURE: %s ]", LEVEL[4], signature));
	}
	
	@AfterReturning(pointcut = "performanceTargets()", returning = "returnValue")
	public void afterExecution(JoinPoint joinPoint, Object returnValue) {
		Signature signature = joinPoint.getSignature();
		logger.info(String.format("[%s] [ leaving < %s >]", LEVEL[3], signature.getName()));
		logger.info(String.format("[%s] [ SIGNATURE: %s ]", LEVEL[4], signature));
		logger.info(DIVIDER);
	}
	
	@Around("performanceTargets()")
	public Object logPerformance(ProceedingJoinPoint joinPoint) {
		try {
			long start = System.nanoTime();
			Object result = joinPoint.proceed();
			long end = System.nanoTime();
			
			String name = joinPoint.getSignature().getName();
			
			logger.info(String.format("[%s] [ < %s > took %d ns execution time ]", LEVEL[3], name, (end - start)));
			
			return result;
		} catch(Throwable e) {
			throw new RuntimeException(e);
		}
	}
	
}