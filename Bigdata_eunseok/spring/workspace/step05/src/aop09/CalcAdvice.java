package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CalcAdvice {
	@Around("execution(* *(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("** 연산 시작 **");
		joinPoint.proceed();
		System.out.println("** 연산 종료 **");
	}
}
