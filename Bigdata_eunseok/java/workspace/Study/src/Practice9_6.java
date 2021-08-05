import java.util.Scanner;
public class Practice9_6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print("몇 단을 출력할지 입력하세요: ");
			int n = s.nextInt();
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", n, i, n*i);
			}
			System.out.print("계속할지 선택하세요. (y:계속): ");
			char c = s.next().toLowerCase().charAt(0);
			if(c != 'y') break; 
		}
	}
}
