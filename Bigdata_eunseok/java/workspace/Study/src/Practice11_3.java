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
		
		System.out.print("���� �Է� : ");
		n = s.nextInt();
		System.out.print("�Ǽ� �Է� : ");
		m = s.nextDouble();
		
		System.out.println("���� ���� : " + square(n));
		System.out.println("�Ǽ� ���� : " + square(m));
	}
}
