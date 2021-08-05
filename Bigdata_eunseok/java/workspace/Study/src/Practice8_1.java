import java.util.Scanner;
public class Practice8_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int kor = s.nextInt();
		System.out.print("영어 점수 : ");
		int eng = s.nextInt();
		System.out.print("수학 점수 : ");
		int math = s.nextInt();
		
		if( (kor + eng + math)/3 >= 60 && kor > 40 && eng > 40 && math > 40) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
}
