import java.util.Scanner;
public class Practice8_3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int mid, end, study, in;
		double score = 0;
		
		System.out.print("�߰���縦 �Է��Ͻÿ� : ");
		mid = s.nextInt();
		System.out.print("�⸻��縦 �Է��Ͻÿ� : ");
		end = s.nextInt();
		
		score += (mid + end) / 2 * 0.6;
		
		System.out.print("���������� �Է��Ͻÿ� : ");
		study = s.nextInt();
		
		score += study * 0.2;
		
		System.out.print("�⼮������ �Է��Ͻÿ� : ");
		in = s.nextInt();
		
		score += in * 0.2;
		
		char c;
		String str;
		
		System.out.println(String.format("����=%.2f", score));
		if(score >= 90) c = 'A';
		else if(score >= 80) c = 'B';
		else if(score >= 70) c = 'C';
		else if(score >= 60) c = 'D';
		else c = 'F';
		System.out.println("����=" + c);
		if(c=='A'||c=='B') str = "excellent";
		else if(c=='C'||c=='D') str = "good";
		else str = "poor";
		System.out.println("��=" + str);
	}
}
