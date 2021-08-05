
import java.util.Scanner;
public class Practice1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = s.next();
		System.out.print("기본급 입력 : ");
		double pay = s.nextDouble();
		
		System.out.printf("*** %s의 월급 *** \n기본급 : %f원\n세금  : %f원\n월급  : %f원", name, pay, pay*0.033, pay - pay * 0.033);
	}
}
