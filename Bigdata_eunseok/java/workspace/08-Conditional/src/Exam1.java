import java.util.Scanner;
public class Exam1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = s.nextInt();
		if(score >= 90 && score <= 100) {
			System.out.println("A 학점입니다.");
		}
		if(score >= 80 && score < 90) {
			System.out.println("B 학점입니다.");
		}
		if(score >= 70 && score < 80) {
			System.out.println("C 학점입니다.");
		}
		if(score >= 60 && score < 70) {
			System.out.println("D 학점입니다.");
		}
		if(score >= 0 && score < 60) {
			System.out.println("F 학점입니다.");
		}
	}
}
