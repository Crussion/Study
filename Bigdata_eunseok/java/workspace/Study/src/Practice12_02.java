import java.util.Scanner;

class Gugudan{
	int start, end;
	Scanner s = new Scanner(System.in);
	
	void setGugudan(int n, int m) {
		start = n;
		end = m;
	}
	void setGugudan() {
		System.out.print("���۴� : ");
		start = s.nextInt();
		System.out.print("���� : ");
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
		
		System.out.print("���۴� : ");
		n = s.nextInt();
		System.out.print("���� : ");
		m = s.nextInt();
		
		g.setGugudan(n,m);
		g.dispGugudan();
	}
}
