class Calc{
	int plus(int x, int y) {
		return x + y;
	}
	int minus(int x, int y) {
		return x - y;
	}
	int multiply(int x, int y) {
		return x * y;
	}
	int divide(int x, int y) {
		return x / y;
	}
	int f(int x, int y) {
		return plus(x, y) + multiply(x, y);
	}
}
public class Exam4 {
	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println(calc.plus(5, 7));
		System.out.println(calc.minus(5, 7));
		System.out.println(calc.multiply(5, 7));
		System.out.println(calc.divide(5, 7));
		System.out.println(calc.f(5, 7));
	}
}
