import java.util.Scanner;
public class Practice8_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int kor = s.nextInt();
		System.out.print("���� ���� : ");
		int eng = s.nextInt();
		System.out.print("���� ���� : ");
		int math = s.nextInt();
		
		if( (kor + eng + math)/3 >= 60 && kor > 40 && eng > 40 && math > 40) {
			System.out.println("�հ�");
		}else {
			System.out.println("���հ�");
		}
	}
}
