import java.util.Scanner;
public class Practice9_7 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print("*************"
					+ "\n1. �Է�"
					+ "\n2. �˻�"
					+ "\n3. ����"
					+ "\n4. ����"
					+ "\n*************\n");
			System.out.print("��ȣ ���� : ");
			int i = s.nextInt();
			String str;
			switch(i) {
			case 1: str = "�Է�"; break;
			case 2: str = "�˻�"; break;
			case 3: str = "����"; break;
			default: str = "end";
			}
			if(str.equals("end")) {
				System.out.println("\n���α׷��� �����մϴ�.");
				break;
			}
			else System.out.printf("\n%s��(��) �����Ͽ����ϴ�.\n\n", str);
		}
	}
}
