import java.util.Scanner;
class Sub7{
	Scanner s = new Scanner(System.in);
	int[] student;
	double sum;
	public void input() {
		student = new int[5];
		for(int i = 1; i <= 5; i++) {
			System.out.print(i+"�� �л��� ������ �Է� : ");
			student[i-1] = s.nextInt();
		}
	}
	//�� ���
	public void calc_sum() {
		sum = 0;
		for(int i = 0; i < student.length; i++) {
			sum += student[i];
		}
	}
	//���
	public void output() {
		System.out.printf("���� : %.0f, ��� : %.2f", sum, sum/student.length);
	}
	
}
public class Practice12_07 {		
		public static void main(String[] args) {
			Sub7 sub7 = new Sub7();
			sub7.input();
			sub7.calc_sum();
			sub7.output();
		}
}
