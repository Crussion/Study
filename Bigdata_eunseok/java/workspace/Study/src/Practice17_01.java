class Circle{
	int r;
	double size, PI = 3.141592;
	
	Circle(int r){
		this.r = r;
	}
	void compute() {};
	void output() {};
}
class CircleArea extends Circle{
	CircleArea(int r){
		super(r);
	}
	
	void compute() {
		size = r * r * PI;
	}
	
	void output() {
		compute();
		System.out.println("원의넓이 : " + size);
	}
}
class CircleRound extends Circle{
	CircleRound(int r){
		super(r);
	}
	
	void compute() {
		size = r * 2 * PI;
	}
	
	void output() {
		compute();
		System.out.println("원의둘레 : " + size);
	}
}
public class Practice17_01 {
	public static void main(String[] args) {
		Circle c1 = new CircleArea(10);
		Circle c2 = new CircleRound(10);
		
		c1.output();
		c2.output();
	}
}
