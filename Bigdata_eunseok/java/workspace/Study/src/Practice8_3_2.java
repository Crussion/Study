import java.util.Scanner;
public class Practice8_3_2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("첫 번째 수 : ");
		double n = s.nextDouble();
		System.out.print("두 번째 수 : ");
		double m = s.nextDouble();
		System.out.print("연산자 : ");
		char c = s.next().charAt(0);
		double result = 0;
		switch(c) {
		case '+': result = n + m; break;
		case '-': result = n - m; break;
		case '*': result = n * m; break;
		case '/': result = n / m; break;
		}
		System.out.printf("%f %c %f = %f", n, c, m, result);
	}
}
