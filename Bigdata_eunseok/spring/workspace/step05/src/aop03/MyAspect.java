package aop03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void before(JoinPoint joinpoint) {
		System.out.println("교실문을 연다");
	}
	
	public void after(JoinPoint joinpoint) {
		System.out.println("교실문을 닫는다");
	}
}
