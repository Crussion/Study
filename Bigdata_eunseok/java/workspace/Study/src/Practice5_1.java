import java.util.Scanner;

public class Practice5_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		int eng;
		int math;
		
		System.out.print("이름? ");
		name = sc.next();
		System.out.print("국어? ");
		kor = sc.nextInt();
		System.out.print("영어? ");
		eng = sc.nextInt();
		System.out.print("수학? ");
		math = sc.nextInt();
		
		System.out.printf("이름 : %s\n총점 : %d", name, kor + eng + math);
		
	}
}
