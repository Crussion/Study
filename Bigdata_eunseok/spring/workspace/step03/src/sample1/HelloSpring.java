package sample1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 1. 객체 생성 : 일반적인 방법, new 사용
		MessageBeanImpl bean1 = new MessageBeanImpl("딸기");
		bean1.setCost(5000);
		bean1.sayHello();
		bean1.sayHello("바나나", 5500);
		
		System.out.println("-----------------");
		// 2. bean 객체 사용
		// 1) 스프링 컨테이너 구동 : bean.xml에 설정된 대로 bean 객체 생성
		System.out.println("스프링 컨테이너 준비 시작");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample1/bean.xml");
		System.out.println("스프링 컨테이너 준비 끝");
		
		// 2) bean 객체 얻어오기
		MessageBeanImpl bean2 = (MessageBeanImpl)context.getBean("messageBean");
		bean2.sayHello();
		bean2.sayHello("바나나", 6000);
		
		System.out.println("------------------------");
		MessageBeanImpl bean3 = (MessageBeanImpl)context.getBean("messageBean1");
		bean3.sayHello();
		bean3.sayHello("바나나", 7000);
		
		// 3) 스프링 컨테이너 종료
		context.close();
	}
}
