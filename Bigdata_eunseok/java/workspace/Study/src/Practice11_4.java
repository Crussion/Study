import java.util.Scanner;

public class Practice11_4 {
	
	public static int[] input() {
		int kor, eng, math;
		Scanner s = new Scanner(System.in);
		System.out.print("���� ���� : ");
		kor = s.nextInt();
		System.out.print("���� ���� : ");
		eng = s.nextInt();
		System.out.print("���� ���� : ");
		math = s.nextInt();
		return new int[] {kor, eng, math};
	}
	
	public static double calc_avg(int[] n, int len) {
		return (double)(n[0] + n[1] + n[2]) / len;
	}
	
	public static void output(double avr, int[] score) {
		if(score[0] >= 40 && score[1] >= 40 && score[2] >= 40 && avr >= 60)
			System.out.println("�հ�");
		else
			System.out.println("���հ�");
	}
	
	public static void main(String[] args) {
		int[] in = input();
		output(calc_avg(in,3), in);
	}
	
}
