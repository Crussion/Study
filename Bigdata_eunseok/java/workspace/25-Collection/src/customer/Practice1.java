package customer;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Customer customer = new CustomerImpl();
		int n = 0;
		
		while(true) {
			do {
				System.out.print("1. �Է�\n"
							   + "2. ���\n"
							   + "3. ����ȣ�˻�\n"
							   + "4. �̸��˻�\n"
							   + "5. ��ȭ��ȣ�˻�\n"
							   + "6. �̸� �������� ����\n"
							   + "7. ����ȣ �������� ����\n"
							   + "8. ����\n"
							   + "---------------------\n"
							   + "��ȣ : ");
				n = s.nextInt();
			}while(n < 1 || n > 8);
			System.out.println();
			switch(n) {
			case 1: customer.input(); break;
			case 2: customer.print(); break;
			case 3: customer.serchNum(); break;
			case 4: customer.serchName(); break;
			case 5: customer.serchPhone(); break;
			case 6: customer.descSortName(); break;
			case 7: customer.ascSortNum(); break;
			case 8: System.out.println("�����մϴ�."); System.exit(0);
			}
			System.out.println();
		}
	}
}
