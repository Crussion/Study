package anno2;

public class MyFoodMgr {
	Food favoriteFood, hateFood;
	
	public void info() {
		System.out.println("[좋아하는 음식 = " + favoriteFood.toString());
		System.out.println("싫어하는 음식 = " + hateFood.toString() + "]");
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getHateFood() {
		return hateFood;
	}

	public void setHateFood(Food hateFood) {
		this.hateFood = hateFood;
	}
	
	
}
