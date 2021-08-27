package anno2;

public class Food {
	String foodName;
	int foodPrice;
	
	public Food() {}
	public Food(String foodName, int foodPrice) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}
	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}
	
}
