import java.util.Scanner;
public class Practice10_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[] student = new int[5];
		float sum = 0;
		for(int i = 1; i <= 5; i++) {
			System.out.print(i+"�� �л��� ������ �Է� : ");
			student[i-1] = s.nextInt();
			sum += student[i-1];
		}
		
		System.out.printf("���� : %.0f, ��� : %.2f", sum, sum/student.length);
	}
}
