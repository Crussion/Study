import java.util.Scanner;

public class Practice11_7 {
	public static int input_menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("\n1. 예금 2. 출급 3. 잔고 4. 종료");
		System.out.print("번호 선택 : ");
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
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
		return money;
	}
	public static int input_deposit() {
		Scanner s = new Scanner(System.in);
		System.out.print("예금액 : ");
		return s.nextInt();
	}
	public static int input_withdrawal() {
		Scanner s = new Scanner(System.in);
		System.out.print("출금액 : ");
		return s.nextInt();
	}
	public static void output_balance(int money) {
		System.out.println("잔고액 : " + money);
	}
	public static void main(String[] args) {
		int money = 0;
		while(true) {
			int n = input_menu();
			money = check_end(n, money);
		}
	}
}
