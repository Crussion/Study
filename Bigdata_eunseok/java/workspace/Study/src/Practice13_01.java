class Triangle{
	int hight, width;
	
	Triangle(){
		hight = 0;
		width = 0;
	}
	
	Triangle(int width, int hight){
		this.width = width;
		this.hight = hight;
	}
	
	void setTriangle(int n, int m) {
		width = n;
		hight = m;
	}
	
	double getArea() {
		return width * hight / 2.0;
	}
	
}
public class Practice13_01 {
	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		t1.setTriangle(5, 12);
		System.out.println("»ï°¢ÇüÀÇ ³ÐÀÌ : " + t1.getArea());
		
		Triangle t2 = new Triangle(45, 7);
		System.out.println("»ï°¢ÇüÀÇ ³ÐÀÌ : " + t2.getArea());
	}
}
