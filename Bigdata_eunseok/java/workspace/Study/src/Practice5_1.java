import java.util.Scanner;

public class Practice5_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		int eng;
		int math;
		
		System.out.print("�̸�? ");
		name = sc.next();
		System.out.print("����? ");
		kor = sc.nextInt();
		System.out.print("����? ");
		eng = sc.nextInt();
		System.out.print("����? ");
		math = sc.nextInt();
		
		System.out.printf("�̸� : %s\n���� : %d", name, kor + eng + math);
		
	}
}
