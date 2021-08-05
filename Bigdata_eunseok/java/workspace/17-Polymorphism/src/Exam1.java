
class Living{
	void live() {
		System.out.println("살아있다.");
	}
	void breath() {}
}
class Animal extends Living{
	void breath() {
		System.out.println("산소로 호흡한다.");
	}
	void move() {
		System.out.println("움직인다.");
	}
}
class Mammalia extends Animal{
	void bringinUp() {
		System.out.println("젖으로 새끼를 양육한다.");
	}
	void walk() {
		System.out.println("네발로 걷는다.");
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Living r1 = new Living();
		Living r2 = new Animal();
		Living r3 = new Mammalia();
		
		r2.breath();
		
		r1.live();
		r2.live();
		r3.live();
	}
}
