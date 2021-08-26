package sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FooTestApp {
	public static void main(String[] args) {
		System.out.println("bean 객체 준비 시작");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample2/bean.xml");
		System.out.println("bean 객체 준비 끝");
		
		context.close();
	}
}
