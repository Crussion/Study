import java.util.Scanner;
class Sub5{
	Scanner s = new Scanner(System.in);
	int n, c;
	
	public void input_dan() {
		System.out.print("몇 단을 출력할지 입력하세요: ");
		n = s.nextInt();
	}
	public void disp_gugudan() {
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", n, i, n*i);
		}
	}
	public void input_y() {
		System.out.print("계속할지 선택하세요. (y:계속): ");
		c = s.next().toLowerCase().charAt(0);
	}
	public void check_end() {
		if(c != 'y')
			System.exit(0);
	}
}
public class Practice12_05 {
	public static void main(String[] args) {
		Sub5 sub5 = new Sub5();
		while(true) {
			sub5.input_dan();
			sub5.disp_gugudan();
			sub5.input_y();
			sub5.check_end();
		}
	}
}
