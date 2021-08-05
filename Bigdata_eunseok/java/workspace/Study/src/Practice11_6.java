import java.util.Scanner;

public class Practice11_6 {
	public static int input_dan() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("몇 단을 출력할지 입력하세요: ");
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
		System.out.print("계속할지 선택하세요. (y:계속): ");
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
