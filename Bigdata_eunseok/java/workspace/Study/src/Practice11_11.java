import java.util.Scanner;

public class Practice11_11 {
	public static String[] input_name(String[] name, Scanner s) {
		for(int i = 0; i < name.length; i++) {
			System.out.print("이름 : ");
			name[i] = s.next();
		}
		return name;
	}
	public static int[][] input_score(int[][] score, Scanner s){
		for(int i = 0; i < score.length; i++) {
			System.out.print("국어 : ");
			score[i][0] = s.nextInt();
			System.out.print("영어 : ");
			score[i][1] = s.nextInt();
			System.out.print("수학 : ");
			score[i][2] = s.nextInt();
		}
		return score;
	}
	public static double[][] calc_avg(int[][] score) {
		double[] total = new double[score.length];
		double[] avg = new double[score.length];
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				total[i] += score[i][j];
			}
			avg[i] = ((double)total[i]/score.length);
		}
		return new double[][] {total, avg};
	}
	public static char[] calc_grade(double[] avg) {
		char[] grade = new char[avg.length];
		for(int i = 0; i < avg.length; i++) {
			if(avg[i] >= 90) grade[i] = 'A';
			else if(avg[i] >= 80) grade[i] = 'B';
			else if(avg[i] >= 70) grade[i] = 'C';
			else if(avg[i] >= 60) grade[i] = 'D';
			else grade[i] = 'F';
		}
		return grade;
	}
	public static void output(String[] name, int[][] score, double[] total, double[] avg, char[] grade) {
		System.out.println("----------------------------------------");
		System.out.println("이름   국어   영어   수학   총점   평균   학점");
		System.out.println("----------------------------------------");
		for(int i = 0; i < name.length; i++) {
			System.out.printf("%s%5d%5d%5d%7.0f%7.1f   %c\n", name[i], score[i][0], score[i][1], score[i][2], total[i], avg[i], grade[i]);
		}
		System.out.println("----------------------------------------");
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] name = new String[3];
		int score[][] = new int[3][3];
		double[] total = new double[3];
		double[] avg = new double[3];
		char[] grade = new char[3];
		
		name = input_name(name, s);
		score = input_score(score, s);
		double[][] temp = calc_avg(score);
		total = temp[0];
		avg = temp[1];
		grade = calc_grade(avg);
		output(name, score, total, avg, grade);
	}
}
