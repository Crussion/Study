package sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BirthdayEx {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample5/bean.xml");
		
		DateVo ob1 = (DateVo) context.getBean("hong");
		System.out.println(ob1.toString());
		System.out.println("-----------");
		DateVo ob2 = (DateVo) context.getBean("lee");
		System.out.println(ob2.toString());
	}
}
