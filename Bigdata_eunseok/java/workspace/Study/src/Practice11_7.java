import java.util.Scanner;

public class Practice11_7 {
	public static int input_menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("\n1. ���� 2. ��� 3. �ܰ� 4. ����");
		System.out.print("��ȣ ���� : ");
		int n = s.nextInt();
		return n;
	}
	public static int check_end(int n, int money) {
		if(n == 1) {
			money += input_deposit();
		}else if(n == 2) {
			money -= input_withdrawal();
		}else if(n == 3) {
			output_balance(money);
		}else{
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}
		return money;
	}
	public static int input_deposit() {
		Scanner s = new Scanner(System.in);
		System.out.print("���ݾ� : ");
		return s.nextInt();
	}
	public static int input_withdrawal() {
		Scanner s = new Scanner(System.in);
		System.out.print("��ݾ� : ");
		return s.nextInt();
	}
	public static void output_balance(int money) {
		System.out.println("�ܰ�� : " + money);
	}
	public static void main(String[] args) {
		int money = 0;
		while(true) {
			int n = input_menu();
			money = check_end(n, money);
		}
	}
}
