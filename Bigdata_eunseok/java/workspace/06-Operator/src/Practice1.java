
import java.util.Scanner;
public class Practice1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("�̸� �Է� : ");
		String name = s.next();
		System.out.print("�⺻�� �Է� : ");
		double pay = s.nextDouble();
		
		System.out.printf("*** %s�� ���� *** \n�⺻�� : %f��\n����  : %f��\n����  : %f��", name, pay, pay*0.033, pay - pay * 0.033);
	}
}
