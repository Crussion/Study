class Circle_2{
	private static Circle_2 instance;
	private int r;
	private double size, PI = 3.141592;
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public static Circle_2 getInstance() {
		if(instance == null) instance = new Circle_2();
		return instance;
	}
	
	public void compute_area() {
		setSize(r * r * PI);
	}
	
	public void compute_round() {
		setSize(2 * r * PI);
	}
	
	public void output_area() {
		compute_area();
		System.out.printf("원의 넓이 = %.2f\n", getSize());
	}
	
	public void output_round() {
		compute_round();
		System.out.printf("원의 둘레 = %.2f\n", getSize());
	}
}
public class Practice20_01 {
	public static void main(String[] args) {
		Circle_2 c = Circle_2.getInstance();
		c.setR(5);
		c.output_area();
		c.output_round();
	}
}
