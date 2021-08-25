package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample4/bean.xml");
		MessageBean bean = (MessageBean) context.getBean("messageEn");
		bean.sayHello();
	}
} 
