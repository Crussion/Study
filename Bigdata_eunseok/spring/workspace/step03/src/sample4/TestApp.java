package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample4/bean.xml");
		
		System.out.println("----------------");
		AbstractTest test = (AbstractTest) context.getBean("test");
		System.out.println("오늘은 " + test.dayInfo());
		
		context.close();
	}
}
