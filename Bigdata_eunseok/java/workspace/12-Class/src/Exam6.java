import java.util.Scanner;

class Score{
	int num;
	String name;
	int kor, eng, mat, tot, avg;
	
	void set() {
		System.out.println(this);
		Scanner s = new Scanner(System.in);
		
		System.out.print("�й� : ");
		num = s.nextInt();
		System.out.print("�̸� : ");
		name = s.next();
		System.out.print("���� : ");
		kor = s.nextInt();
		System.out.print("���� : ");
		eng = s.nextInt();
		System.out.print("���� : ");
		mat = s.nextInt();
		
		tot = kor + eng + mat;
		avg = tot / 3;
	}
	void print_title() {
		System.out.println(this);
		System.out.println("*** ���� ��� ***");
		System.out.println("�й�\t\t�̸�\t����\t����\t����\t����\t���");
	}
	void print() {
		System.out.println(this);
		System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\n", num, name, kor, eng, mat, tot, avg);
	}
}
public class Exam6 {
	public static void main(String[] args) {
		Score s1 = new Score();
		Score s2 = new Score();
		System.out.printf("s1 = %s, s2 = %s\n", s1, s2);
		System.out.println("--------------------");
		s1.set();
		s2.set();
		
		System.out.println("--------------------");
		
		s1.print_title();
		System.out.println("--------------------");
		s1.print();
		s2.print();
	}
}
