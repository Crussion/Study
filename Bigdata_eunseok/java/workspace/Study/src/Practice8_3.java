import java.util.Scanner;
public class Practice8_3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int mid, end, study, in;
		double score = 0;
		
		System.out.print("중간고사를 입력하시오 : ");
		mid = s.nextInt();
		System.out.print("기말고사를 입력하시오 : ");
		end = s.nextInt();
		
		score += (mid + end) / 2 * 0.6;
		
		System.out.print("과제점수를 입력하시오 : ");
		study = s.nextInt();
		
		score += study * 0.2;
		
		System.out.print("출석점수를 입력하시오 : ");
		in = s.nextInt();
		
		score += in * 0.2;
		
		char c;
		String str;
		
		System.out.println(String.format("성적=%.2f", score));
		if(score >= 90) c = 'A';
		else if(score >= 80) c = 'B';
		else if(score >= 70) c = 'C';
		else if(score >= 60) c = 'D';
		else c = 'F';
		System.out.println("학점=" + c);
		if(c=='A'||c=='B') str = "excellent";
		else if(c=='C'||c=='D') str = "good";
		else str = "poor";
		System.out.println("평가=" + str);
	}
}
