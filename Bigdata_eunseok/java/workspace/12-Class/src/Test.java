import java.util.Scanner;
class AAA{
	Scanner s = new Scanner(System.in);
	int a, b, c;
	
	void input() {
		System.out.print("정수 입력 : ");
		this.a = s.nextInt();
		System.out.print("정수 입력 : ");
		this.b = s.nextInt();
	}
	void plus() {
		this.c = this.a + this.b;
	}
	void output() {
		System.out.println(c);
	}
}
public class Test {
	public static void main(String[] args) {
		AAA aaa = new AAA();
		aaa.input();
		aaa.plus();
		aaa.output();
	}
}
