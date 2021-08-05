class Calc{
	private static Calc instance;
	public static Calc getInstance() {
		if(instance == null) instance = new Calc();
		return instance;
	}
	
	public void plus(int x, int y) {
		System.out.printf("%d + %d = %d\n", x, y, x + y);
	}
	public void minus(int x, int y) {
		System.out.printf("%d - %d = %d\n", x, y, x - y);
	}
	public void multiply(int x, int y) {
		System.out.printf("%d * %d = %d\n", x, y, x * y);
	}
	public void divide(int x, int y) {
		System.out.printf("%d / %d = %f\n", x, y, x / (double)y);
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Calc c = Calc.getInstance();
		c.plus(5, 7);
		c.minus(5, 7);
		c.multiply(5, 7);
		c.divide(5, 7);
		
		Calc.getInstance().plus(10, 20);
		Calc.getInstance().minus(10, 20);
		Calc.getInstance().multiply(10, 20);
		Calc.getInstance().divide(10, 20);
	}
}
