import java.util.Scanner;
public class Practice9_6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print("�� ���� ������� �Է��ϼ���: ");
			int n = s.nextInt();
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", n, i, n*i);
			}
			System.out.print("������� �����ϼ���. (y:���): ");
			char c = s.next().toLowerCase().charAt(0);
			if(c != 'y') break; 
		}
	}
}
