import java.util.Scanner;
public class Exam3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int score = s.nextInt();
		String result = "";
		
		if(score >= 90) result = "A����";
		else if(score >= 80) result = "B����";
		else if(score >= 70) result = "C����";
		else if(score >= 60) result = "D����";
		else result = "F����";
		System.out.println(score + " : " + result);
	}
}
