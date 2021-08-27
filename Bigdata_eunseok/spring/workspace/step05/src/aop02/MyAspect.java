package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object returnValue = null;
		
		// 대상 메소드 실행전 코드
		System.out.println("교실문을 연다.");
		
		try {
			// 대상 메소드 실행 (핵심 관심 사항)
			returnValue = invocation.proceed();
		}catch(Exception e) {
			// 대상 메소드 실행 중 Exception 발생시 실행되는 코드
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			// 대상 메소드 실행 후 코드
			System.out.println("전등이 켜져있는 지 확인한다.");
		}
		
		// 대상 메소드 실행 후 코드
		System.out.println("교실문을 잠근다.");
		return returnValue;
	}
}
