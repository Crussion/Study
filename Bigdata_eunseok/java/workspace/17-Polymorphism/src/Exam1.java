
class Living{
	void live() {
		System.out.println("����ִ�.");
	}
	void breath() {}
}
class Animal extends Living{
	void breath() {
		System.out.println("��ҷ� ȣ���Ѵ�.");
	}
	void move() {
		System.out.println("�����δ�.");
	}
}
class Mammalia extends Animal{
	void bringinUp() {
		System.out.println("������ ������ �����Ѵ�.");
	}
	void walk() {
		System.out.println("�׹߷� �ȴ´�.");
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
