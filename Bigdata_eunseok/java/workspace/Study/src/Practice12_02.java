import java.util.Scanner;

class Gugudan{
	int start, end;
	Scanner s = new Scanner(System.in);
	
	void setGugudan(int n, int m) {
		start = n;
		end = m;
	}
	void setGugudan() {
		System.out.print("시작단 : ");
		start = s.nextInt();
		System.out.print("끝단 : ");
		end = s.nextInt();
	}
	
	void dispGugudan() {
		for(int i = start; i <= end; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\t", i, j, i * j);
			}
			System.out.println();
		}
	}
}
public class Practice12_02 {
	public static void main(String[] args) {
		Gugudan g = new Gugudan();
		Scanner s = new Scanner(System.in);
		int n, m;
		
		System.out.print("시작단 : ");
		n = s.nextInt();
		System.out.print("끝단 : ");
		m = s.nextInt();
		
		g.setGugudan(n,m);
		g.dispGugudan();
	}
}
