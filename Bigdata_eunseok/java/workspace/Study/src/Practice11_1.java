import java.util.Scanner;
public class Practice11_1 {
	public static boolean doubleNum(int n, int m) {
		return n % m == 0;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int n = s.nextInt();
		System.out.print("���� �Է� : ");
		int m = s.nextInt();
		
		if(doubleNum(n, m)) 
			System.out.println(n + "(��)�� " + m + "�� ��� �Դϴ�.");
		else
			System.out.println(n + "(��)�� " + m + "�� ����� �ƴմϴ�.");
	}
}
