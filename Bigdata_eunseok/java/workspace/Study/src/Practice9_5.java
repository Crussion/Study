
public class Practice9_5 {
	public static void main(String[] args) {
		for(int n = 1; n <= 5; n++) {
			for(int m = 0; m < 5 - n; m++) {
				System.out.print(" ");
			}
			for(int m = 1; m < n * 2; m++)
				System.out.print("*");
			System.out.println();
		}
	}
}
