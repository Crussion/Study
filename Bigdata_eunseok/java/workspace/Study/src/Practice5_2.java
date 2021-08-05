import java.util.Scanner;

public class Practice5_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float width;
		float high;
		
		System.out.println("πÿ∫Ø: ");
		width = sc.nextFloat();
		System.out.println("≥Ù¿Ã: ");
		high = sc.nextFloat();
		
		System.out.printf("%.2f", width*high/2);
	}
}
