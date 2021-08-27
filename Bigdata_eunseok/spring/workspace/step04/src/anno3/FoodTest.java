package anno3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("anno3/bean.xml");
		
		MyFoodMgr foodMgr = (MyFoodMgr) context.getBean("myfood");
		foodMgr.info();
		
		context.close();
	}
}
