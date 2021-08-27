package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	@Before("execution(public void aop04.*.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다");
	}
	
	// 예외가 발생했을 경우
	@AfterThrowing(pointcut = "execution(public void aop04.*.*(..))", throwing = "e")
	public void throwing(JoinPoint joinPoint, Exception e) {
		System.out.println("** 오늘은 소독하는 날 **\n" + e.getMessage());
	}
	
	@After("execution(public void aop04.*.*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 잠근다");
	}
}
