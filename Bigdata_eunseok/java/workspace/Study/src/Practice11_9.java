import java.util.Scanner;

public class Practice11_9 {
	public static int[] input() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("*** �ϼ� ���ϱ� ***");
		System.out.print("�� : ");
		int year = s.nextInt();
		System.out.print("�� : ");
		int n = s.nextInt();
		System.out.print("�� : ");
		int m = s.nextInt();
		return new int[] {year, n, m};
	}
	public static int calc_sum(int year, int n, int m, int[] month) {
		int day = 0;
		for(int i = 2000; i < year; i++) {
			for(int j = 0; j < month.length; j++) {
				day += month[j];
			}
			if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				day++;
			}
		}
		for(int i = 0; i < n - 1; i++) {
			day += month[i];
			if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				if(i == 1) {
					day++;
				}
			}
		}
		day += m;
		return day;
	}
	public static void output(int year, int n, int m, int day) {
		System.out.printf("2000��1��1�Ϻ��� %d��%d��%d�ϱ����� %d�� �Դϴ�.", year, n, m, day);
	}
	public static void main(String[] args) {
		int[] in = input();
		int year = in[0];
		int n = in[1], m = in[2];
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int day = calc_sum(year, n, m, month);
		
		output(year, n, m, day);
	}
}
