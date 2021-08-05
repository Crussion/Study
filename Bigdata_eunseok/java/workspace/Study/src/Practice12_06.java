import java.util.Scanner;
class Sub6{
	Scanner s = new Scanner(System.in);
	int money = 0, n;
	public void input_menu() {
		System.out.println("\n1. 예금 2. 출급 3. 잔고 4. 종료");
		System.out.print("번호 선택 : ");
		n = s.nextInt();
	}
	public void check_end() {
		if(n == 1) {
			money += input_deposit();
		}else if(n == 2) {
			money -= input_withdrawal();
		}else if(n == 3) {
			output_balance();
		}else{
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
	}
	public int input_deposit() {
		System.out.print("예금액 : ");
		return s.nextInt();
	}
	public int input_withdrawal() {
		System.out.print("출금액 : ");
		return s.nextInt();
	}
	public void output_balance() {
		System.out.println("잔고액 : " + money);
	}
}
public class Practice12_06 {
	public static void main(String[] args) {
		Sub6 sub6 = new Sub6();
		while(true) {
			sub6.input_menu();
			sub6.check_end();
		}
	}
}
