package aop09;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop09/bean.xml");
		
		CalcMethod calcMethod = (CalcMethod) context.getBean("calc");
		calcMethod.sum(5, 4);
		System.out.println();
		calcMethod.div(5, 0);
		
		context.close();
	}
}
