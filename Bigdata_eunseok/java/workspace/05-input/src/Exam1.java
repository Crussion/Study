import java.util.Scanner;

public class Exam1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		double math;
		boolean b;
		char ch;
		
		System.out.print("�̸�: ");
		name = sc.next();
		
		System.out.print("����: ");
		kor = sc.nextInt();
		
		System.out.print("����: ");
		math = sc.nextDouble();
		
		System.out.print("����: ");
		b = sc.nextBoolean();
		
		System.out.print("�����Ѱ�: ");
		ch = sc.next().charAt(0);
		System.out.println("----------------------");

		
		System.out.println("�̸�: " + name);
		System.out.println("����: " + kor);
		System.out.println("����: " + math);
		System.out.println("����: " + b);
		System.out.println("�����Ѱ�: " + ch);
	}
}
