import java.util.Scanner;

public class Practice11_5 {
	public static int input() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("1~100 사이의 배수를 구할 숫자 입력 : ");
		int n = s.nextInt();
		return n;
	}
	public static int calc(int n) {
		int cnt = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % n == 0) {
				System.out.print(i + " ");
				cnt++;
			}
		}
		return cnt;
	}
	public static void output(int n, int cnt) {
		System.out.println();
		System.out.println("1~100 사이의 " + n + "의 배수 개수 = " + cnt);
	}
	public static void main(String[] args) {
		int n = input();
		int cnt = calc(n);
		output(n, cnt);
	}
}
