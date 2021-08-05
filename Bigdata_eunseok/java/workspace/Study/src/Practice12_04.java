import java.util.Scanner;
class Sub4{
	int kor, eng, math;
	double avg;
	public void input() {
		Scanner s = new Scanner(System.in);
		System.out.print("국어 점수 : ");
		kor = s.nextInt();
		System.out.print("영어 점수 : ");
		eng = s.nextInt();
		System.out.print("수학 점수 : ");
		math = s.nextInt();
	}
	public void calc_avg(int len) {
		avg = (double)(kor + eng + math) / len;
	}
	public void output() {
		if(kor >= 40 && eng >= 40 && math >= 40 && avg >= 60)
			System.out.println("합격");
		else
			System.out.println("불합격");
	}
}
public class Practice12_04 {
	public static void main(String[] args) {
		Sub4 sub4 = new Sub4();
		sub4.input();
		sub4.calc_avg(3);
		sub4.output();
	}
}
