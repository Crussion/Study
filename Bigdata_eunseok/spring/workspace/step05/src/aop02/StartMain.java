package aop02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop02/bean.xml");
		
		Person person = (Person) context.getBean("man");
		person.classwork();
		System.out.println("--------------------");
		
		person = (Person) context.getBean("woman");
		person.classwork();
		
		context.close();
	}
}
