import java.util.Scanner;
public class Exam3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int score = s.nextInt();
		String result = "";
		
		if(score >= 90) result = "A학점";
		else if(score >= 80) result = "B학점";
		else if(score >= 70) result = "C학점";
		else if(score >= 60) result = "D학점";
		else result = "F학점";
		System.out.println(score + " : " + result);
	}
}
