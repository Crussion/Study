import java.util.Scanner;
public class Practice10_2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("*** �ϼ� ���ϱ� ***");
		System.out.print("�� : ");
		int year = s.nextInt();
		System.out.print("�� : ");
		int n = s.nextInt();
		System.out.print("�� : ");
		int m = s.nextInt();
		int cnt = 0;
		int day = 0;
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int i = 2000; i < year; i++) {
			for(int j = 0; j < month.length; j++) {
				day += month[j];
			}
			if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				day++;
				cnt++;
			}
		}
		for(int i = 0; i < n - 1; i++) {
			day += month[i];
			if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				if(i == 1) {
					day++;
					cnt++;
				}
			}
		}
		day += m;
		
		System.out.printf("1��1�Ϻ��� %d��%d�ϱ����� %d�� �Դϴ�.", n, m, day);
		System.out.println(cnt);
	}
}
