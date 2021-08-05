import java.util.Scanner;

public class Practice11_4 {
	
	public static int[] input() {
		int kor, eng, math;
		Scanner s = new Scanner(System.in);
		System.out.print("국어 점수 : ");
		kor = s.nextInt();
		System.out.print("영어 점수 : ");
		eng = s.nextInt();
		System.out.print("수학 점수 : ");
		math = s.nextInt();
		return new int[] {kor, eng, math};
	}
	
	public static double calc_avg(int[] n, int len) {
		return (double)(n[0] + n[1] + n[2]) / len;
	}
	
	public static void output(double avr, int[] score) {
		if(score[0] >= 40 && score[1] >= 40 && score[2] >= 40 && avr >= 60)
			System.out.println("합격");
		else
			System.out.println("불합격");
	}
	
	public static void main(String[] args) {
		int[] in = input();
		output(calc_avg(in,3), in);
	}
	
}
