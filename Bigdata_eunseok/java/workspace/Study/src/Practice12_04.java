import java.util.Scanner;
class Sub4{
	int kor, eng, math;
	double avg;
	public void input() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� ���� : ");
		kor = s.nextInt();
		System.out.print("���� ���� : ");
		eng = s.nextInt();
		System.out.print("���� ���� : ");
		math = s.nextInt();
	}
	public void calc_avg(int len) {
		avg = (double)(kor + eng + math) / len;
	}
	public void output() {
		if(kor >= 40 && eng >= 40 && math >= 40 && avg >= 60)
			System.out.println("�հ�");
		else
			System.out.println("���հ�");
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
