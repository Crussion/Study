import java.util.Scanner;
public class Practice8_2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("�������� �Է� : ");
		int kor = s.nextInt();
		System.out.print("�������� �Է� : ");
		int eng = s.nextInt();
		double result = (kor + eng) / 2.0;
		char score;
		System.out.println("���� = " + (kor + eng));
		System.out.println("��� = " + result);
		if(result >= 90) score = 'A';
		else if(result >= 80) score = 'B';
		else if(result >= 70) score = 'C';
		else if(result >= 60) score = 'D';
		else score = 'F';
		System.out.println("���� = " + score);
	}
	
}
