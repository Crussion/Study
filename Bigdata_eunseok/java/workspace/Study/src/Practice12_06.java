import java.util.Scanner;
class Sub6{
	Scanner s = new Scanner(System.in);
	int money = 0, n;
	public void input_menu() {
		System.out.println("\n1. ���� 2. ��� 3. �ܰ� 4. ����");
		System.out.print("��ȣ ���� : ");
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
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}
	}
	public int input_deposit() {
		System.out.print("���ݾ� : ");
		return s.nextInt();
	}
	public int input_withdrawal() {
		System.out.print("��ݾ� : ");
		return s.nextInt();
	}
	public void output_balance() {
		System.out.println("�ܰ�� : " + money);
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
