import java.util.Scanner;
public class Exam8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		int result;
		
		System.out.print("���� �Է� : ");
		num1 = sc.nextInt();
		System.out.print("���� �Է� : ");
		num2 = sc.nextInt();
		
		result = num1 > num2 ? num1 : num2;
		System.out.println("ū �� : " + result);
	}
}
