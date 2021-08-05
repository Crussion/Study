import java.util.Scanner;
public class Exam4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int score;
		char grade;
		
		System.out.print("점수 입력 : ");
		score = s.nextInt();
		
		switch(score/10) {
		case 10:
		case 9 : grade = 'A'; break;
		case 8 : grade = 'B'; break;
		case 7 : grade = 'C'; break;
		case 6 : grade = 'D'; break;
		default : grade = 'F';
		}
		System.out.print("성적 : " + grade);
	}
}
