package aop08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AdviceEx {
	@Around("execution(* zeroMethod(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("JoinPoint 양쪽의 전에 실행되는 Advice");
		joinPoint.proceed();
		System.out.println("JoinPoint 양쪽의 후에 실행되는 Advice");
	}
	
	@Before("execution(* zeroMethod(..))")
	public void befor() throws Throwable {
		System.out.println("JoinPoint 양쪽의 앞에서 실행되는 Advice");
	}
	
	@After("execution(* zeroMethod(..))")
	public void after() throws Throwable {
		System.out.println("JoinPoint 양쪽의 뒤에서 실행되는 Advice");
	}
	
	@AfterThrowing(pointcut = "execution(* zeroMethod(..))", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("예외가 발생할 때 호출되는 Advice");
		System.out.println(e.getMessage());
	}
	
	// 리턴발생시 실행
	@AfterReturning(pointcut = "execution(* zeroMethod(..))", returning = "ret")
	public void afterReturning(Object ret) {
		System.out.println("JoinPoint가 종료된 후 실행되는 Advice");
	}
}
