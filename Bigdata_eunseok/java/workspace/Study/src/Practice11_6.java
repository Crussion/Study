import java.util.Scanner;

public class Practice11_6 {
	public static int input_dan() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("�� ���� ������� �Է��ϼ���: ");
		int n = s.nextInt();
		return n;
	}
	public static void disp_gugudan(int n) {
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", n, i, n*i);
		}
	}
	public static char input_y() {
		Scanner s = new Scanner(System.in);
		System.out.print("������� �����ϼ���. (y:���): ");
		char c = s.next().toLowerCase().charAt(0);
		return c;
	}
	public static void check_end(char c) {
		if(c != 'y')
			System.exit(0);
	}
	public static void main(String[] args) {
		
		while(true) {
			int n = input_dan();
			disp_gugudan(n);
			char c = input_y();
			check_end(c);
		}
	}
}
