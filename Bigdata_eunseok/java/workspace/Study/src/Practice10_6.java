import java.util.Scanner;
public class Practice10_6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] name = new String[3];
		int score[][] = new int[3][3];
		int[] total = new int[3];
		double[] avg = new double[3];
		char[] grade = new char[3];
		
		for(int i = 0; i < name.length; i++) {
			System.out.print("이름 : ");
			name[i] = s.next();
			System.out.print("국어 : ");
			score[i][0] = s.nextInt();
			System.out.print("영어 : ");
			score[i][1] = s.nextInt();
			System.out.print("수학 : ");
			score[i][2] = s.nextInt();
			for(int j = 0; j < score[i].length; j++) {
				total[i] += score[i][j];
			}
			avg[i] = ((double)total[i]/score[i].length);
			if(avg[i] >= 90) grade[i] = 'A';
			else if(avg[i] >= 80) grade[i] = 'B';
			else if(avg[i] >= 70) grade[i] = 'C';
			else if(avg[i] >= 60) grade[i] = 'D';
			else grade[i] = 'F';
		}
		
		System.out.println("----------------------------------------");
		System.out.println("이름   국어   영어   수학   총점   평균   학점");
		System.out.println("----------------------------------------");
		for(int i = 0; i < name.length; i++) {
			System.out.printf("%s%5d%5d%5d%7d%7.1f   %c\n", name[i], score[i][0], score[i][1], score[i][2], total[i], avg[i], grade[i]);
		}
		System.out.println("----------------------------------------");
	}
}
