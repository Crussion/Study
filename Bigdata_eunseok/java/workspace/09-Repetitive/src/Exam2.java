
public class Exam2 {
	public static void main(String[] args) {
		for(int n = 1; n <= 9; n++) {
			for(int m = 2; m <= 9; m++)
				System.out.printf("%d * %d = %2d  ", m, n, m * n);
			System.out.println();
		}
	}
}
