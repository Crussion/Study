import java.util.Scanner;
public class Practice11_1 {
	public static boolean doubleNum(int n, int m) {
		return n % m == 0;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int n = s.nextInt();
		System.out.print("정수 입력 : ");
		int m = s.nextInt();
		
		if(doubleNum(n, m)) 
			System.out.println(n + "(은)는 " + m + "의 배수 입니다.");
		else
			System.out.println(n + "(은)는 " + m + "의 배수가 아닙니다.");
	}
}
