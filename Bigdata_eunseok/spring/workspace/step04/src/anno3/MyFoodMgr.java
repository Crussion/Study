package anno3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myfood")
public class MyFoodMgr {
	@Autowired
	@Qualifier(value="favoriteFood")
	Food favoriteFood;
	@Autowired
	@Qualifier(value="hateFood")
	Food hateFood;
	
	public void info() {
		System.out.println("[좋아하는 음식 = " + favoriteFood.toString());
		System.out.println("싫어하는 음식 = " + hateFood.toString() + "]");
	}
	
}
