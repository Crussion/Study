import java.util.Scanner;
class Sub7{
	Scanner s = new Scanner(System.in);
	int[] student;
	double sum;
	public void input() {
		student = new int[5];
		for(int i = 1; i <= 5; i++) {
			System.out.print(i+"번 학생의 점수를 입력 : ");
			student[i-1] = s.nextInt();
		}
	}
	//합 계산
	public void calc_sum() {
		sum = 0;
		for(int i = 0; i < student.length; i++) {
			sum += student[i];
		}
	}
	//출력
	public void output() {
		System.out.printf("총점 : %.0f, 평균 : %.2f", sum, sum/student.length);
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
