import java.util.Scanner;
public class Practice9_8 {
	public static void main(String[] args) {
		int money = 0;
		while(true) {
			Scanner s = new Scanner(System.in);
			System.out.println("\n1. ���� 2. ��� 3. �ܰ� 4. ����");
			System.out.print("��ȣ ���� : ");
			int n = s.nextInt();
			if(n == 1) {
				System.out.print("���ݾ� : ");
				money += s.nextInt();
			}else if(n == 2) {
				System.out.print("��ݾ� : ");
				money -= s.nextInt();
			}else if(n == 3) {
				System.out.println("�ܰ�� : " + money);
			}else{
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}
}
