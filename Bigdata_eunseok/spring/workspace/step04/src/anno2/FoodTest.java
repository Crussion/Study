package anno2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("anno2/bean1.xml");
		
		MyFoodMgr foodMgr = (MyFoodMgr) context.getBean("myfood");
		foodMgr.info();
		
		context.close();
	}
}
