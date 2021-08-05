
public class Practice9_2 {
	public static void main(String[] args) {
		int sum;
		for(int i = 1; i <= 100; i = i + 10) {
			sum = 0;
			for(int j = i; j < i + 10; j++) {
				sum += j;
			}
			System.out.println(i + " ~ " + (i+9) + " = " + sum);
		}
	}
}
