import java.util.Scanner;
public class Practice11_8 {
	//���� �Է�
	public static int[] input() {
		Scanner s = new Scanner(System.in);
		int[] student = new int[5];
		for(int i = 1; i <= 5; i++) {
			System.out.print(i+"�� �л��� ������ �Է� : ");
			student[i-1] = s.nextInt();
		}
		return student;
	}
	//�� ���
	public static double calc_sum(int[] student) {
		double sum = 0;
		for(int i = 0; i < student.length; i++) {
			sum += student[i];
		}
		return sum;
	}
	//���
	public static void output(double sum, int[] student) {
		System.out.printf("���� : %.0f, ��� : %.2f", sum, sum/student.length);
	}
	
	public static void main(String[] args) {
		int[] student = input();
		double sum = calc_sum(student);
		output(sum, student);
	}
}
