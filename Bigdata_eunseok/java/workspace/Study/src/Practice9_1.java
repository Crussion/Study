import java.util.Scanner;
public class Practice9_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("1~100 ������ ����� ���� ���� �Է� : ");
		int n = s.nextInt();
		int cnt = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % n == 0) {
				System.out.print(i + " ");
				cnt++;
			}
		}
		System.out.println();
		System.out.println("1~100 ������ " + n + "�� ��� ���� = " + cnt);
	}
}
