import java.util.Scanner;
public class Practice9_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("1~100 사이의 배수를 구할 숫자 입력 : ");
		int n = s.nextInt();
		int cnt = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % n == 0) {
				System.out.print(i + " ");
				cnt++;
			}
		}
		System.out.println();
		System.out.println("1~100 사이의 " + n + "의 배수 개수 = " + cnt);
	}
}
