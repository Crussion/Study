import java.util.Scanner;
public class Practice11_2 {
	public static String grade(double score) {
		
		if(score >= 90) return "A";
		else if(score >= 80) return "B";
		else if(score >= 70) return "C";
		else if(score >= 60) return "D";
		else return "F";
	}
	
	public static int input_kor() {
		Scanner s = new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		return s.nextInt();
	}
	public static int input_eng() {
		Scanner s = new Scanner(System.in);
		System.out.print("영어 점수 입력 : ");
		return s.nextInt();
	}
	public static int calc_tot(int n, int m) {
		return n + m;
	}
	public static double calc_avg(double avg, double len) {
		return avg / len;
	}
	public static void output(String str) {
		System.out.println(str + "학점입니다.");
	}
	public static void main(String[] args) {
		
		output(grade(calc_avg(calc_tot(input_kor(), input_eng()), 2)));
		
		/*
		Scanner s = new Scanner(System.in);
		int kor, eng, tot;
		double avg;
		System.out.print("국어 점수 입력 : ");
		kor = s.nextInt();
		System.out.print("영어 점수 입력 : ");
		eng = s.nextInt();
		
		tot = kor + eng;
		avg = (double)tot / 2;
		
		System.out.println(grade(avg)+"학점입니다.");
		*/
	}
}
