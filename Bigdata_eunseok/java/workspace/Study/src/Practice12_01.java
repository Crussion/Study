import java.util.Scanner;

class Triangle_1{
	Scanner s = new Scanner(System.in);
	double hight, width;
	
	void setTriangle(double x, double y) {
		width = x;
		hight = y;
	}
	void setTriangle() {
		System.out.println("ªÔ∞¢«¸ ≥–¿Ã ±∏«œ±‚");
		System.out.print("πÿ∫Ø: ");
		width = s.nextDouble();
		System.out.print("≥Ù¿Ã: ");
		hight = s.nextDouble();
	}
	double getArea() {
		return hight * width / 2;
	}
	void output() {
		System.out.println("ªÔ∞¢«¸¿« ≥–¿Ã: " + getArea());
	}
}
public class Practice12_01 {
	public static void main(String[] args) {
		Triangle_1 t = new Triangle_1();
		t.setTriangle();
		t.output();
	}
}
