import java.util.Scanner;

public class Practice11_3 {
	public static int square(int n) {
		return n * n;
	}
	public static double square(double m) {
		return m * m;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
		double m;
		
		System.out.print("정수 입력 : ");
		n = s.nextInt();
		System.out.print("실수 입력 : ");
		m = s.nextDouble();
		
		System.out.println("정수 제곱 : " + square(n));
		System.out.println("실수 제곱 : " + square(m));
	}
}
