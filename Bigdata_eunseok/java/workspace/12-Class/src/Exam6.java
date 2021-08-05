import java.util.Scanner;

class Score{
	int num;
	String name;
	int kor, eng, mat, tot, avg;
	
	void set() {
		System.out.println(this);
		Scanner s = new Scanner(System.in);
		
		System.out.print("학번 : ");
		num = s.nextInt();
		System.out.print("이름 : ");
		name = s.next();
		System.out.print("국어 : ");
		kor = s.nextInt();
		System.out.print("영어 : ");
		eng = s.nextInt();
		System.out.print("수학 : ");
		mat = s.nextInt();
		
		tot = kor + eng + mat;
		avg = tot / 3;
	}
	void print_title() {
		System.out.println(this);
		System.out.println("*** 성적 출력 ***");
		System.out.println("학번\t\t이름\t국어\t영어\t수학\t총점\t평균");
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
