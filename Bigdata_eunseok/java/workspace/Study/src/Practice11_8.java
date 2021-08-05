import java.util.Scanner;
public class Practice11_8 {
	//점수 입력
	public static int[] input() {
		Scanner s = new Scanner(System.in);
		int[] student = new int[5];
		for(int i = 1; i <= 5; i++) {
			System.out.print(i+"번 학생의 점수를 입력 : ");
			student[i-1] = s.nextInt();
		}
		return student;
	}
	//합 계산
	public static double calc_sum(int[] student) {
		double sum = 0;
		for(int i = 0; i < student.length; i++) {
			sum += student[i];
		}
		return sum;
	}
	//출력
	public static void output(double sum, int[] student) {
		System.out.printf("총점 : %.0f, 평균 : %.2f", sum, sum/student.length);
	}
	
	public static void main(String[] args) {
		int[] student = input();
		double sum = calc_sum(student);
		output(sum, student);
	}
}
