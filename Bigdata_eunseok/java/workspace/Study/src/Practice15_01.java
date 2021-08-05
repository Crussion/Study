class Area{
	double width, height;
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	void setArea(double width, double height) {
		this.width = width;
		this.height = height;
	}
}
class Rectangle extends Area{
	double getArea() {
		return width * height;
	}
}
class Triangle_2 extends Area{
	double getArea() {
		return width * height / 2;
	}
}
public class Practice15_01 {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Triangle_2 t = new Triangle_2();
		
		r.setArea(10.5, 20.5);
		t.setArea(5.0, 9.0);
		
		System.out.println(r.getArea());
		System.out.println(t.getArea());
	}
}
