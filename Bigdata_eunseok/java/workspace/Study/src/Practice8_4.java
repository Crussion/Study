import java.util.Scanner;
public class Practice8_4 {
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
		
		char c = ' ';
		String str = "";
		
		System.out.println(String.format("����=%.2f", score));
		
		switch((int)(score/10)) {
		case 10:
		case 9: c = 'A'; str = "excellent"; break;
		case 8: c = 'B'; str = "excellent"; break;
		case 7: c = 'C'; str = "good"; break;
		case 6: c = 'D'; str = "good"; break;
		default: c = 'F'; str = "poor"; break;
		}
		
		System.out.println("����=" + c);
		System.out.println("��=" + str);
	}
}
