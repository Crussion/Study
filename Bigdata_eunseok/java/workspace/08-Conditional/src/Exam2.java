import java.util.Scanner;
public class Exam2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("�⵵ �Է� : ");
		int year = s.nextInt();
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "���� �����Դϴ�.");
		}else {
			System.out.println(year + "���� ����Դϴ�.");
		}
	}
}