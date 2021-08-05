import java.util.Scanner;

public class Exam1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		double math;
		boolean b;
		char ch;
		
		System.out.print("이름: ");
		name = sc.next();
		
		System.out.print("국어: ");
		kor = sc.nextInt();
		
		System.out.print("수학: ");
		math = sc.nextDouble();
		
		System.out.print("진실: ");
		b = sc.nextBoolean();
		
		System.out.print("문자한개: ");
		ch = sc.next().charAt(0);
		System.out.println("----------------------");

		
		System.out.println("이름: " + name);
		System.out.println("국어: " + kor);
		System.out.println("수학: " + math);
		System.out.println("진실: " + b);
		System.out.println("문자한개: " + ch);
	}
}
