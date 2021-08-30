package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 공통 관심 사항 관리 클래스
public class LoggingAdvice {
	// 매개변수로 호출을 가로챈 함수를 전달받는다.
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{ // Throwable : Exception의 부모 클래스
		// 가로채온 함수의 이름 얻어오기
		String methodName = joinPoint.getSignature().getName();
		
		StopWatch sw = new StopWatch(); // 시간을 재는 클래스
		
		// 공통 관심 사항 : before
		System.out.println("From [bea.xml]");
		System.out.println("[Log] METHOD : " + methodName + " is Calling");
		sw.start();
		
		joinPoint.proceed();	// 핵심 관심 사항
		
		// 공통 관심 사항 : after
		sw.stop();
		System.out.println("[Log] METHOD : " + methodName + " waw done.");
		System.out.println("[Log] 처리시간 : " + sw.getTotalTimeSeconds() + "초");
	}
}
