import java.util.Scanner;
public class Practice9_8 {
	public static void main(String[] args) {
		int money = 0;
		while(true) {
			Scanner s = new Scanner(System.in);
			System.out.println("\n1. 예금 2. 출급 3. 잔고 4. 종료");
			System.out.print("번호 선택 : ");
			int n = s.nextInt();
			if(n == 1) {
				System.out.print("예금액 : ");
				money += s.nextInt();
			}else if(n == 2) {
				System.out.print("출금액 : ");
				money -= s.nextInt();
			}else if(n == 3) {
				System.out.println("잔고액 : " + money);
			}else{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
