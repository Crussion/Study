import java.util.Scanner;
public class Practice2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("input name: ");
		String name = s.next();
		System.out.print("input gender(m/f): ");
		String gender = s.next();
		System.out.print("input age: ");
		int age = s.nextInt();
		System.out.print("input height: ");
		float height = s.nextFloat();
		
		System.out.printf("�̸� : %s \n���� : %s \n���� : %d�� \n���� : %.1fcm", name, gender.equals("m") ? "����":"����", age, height);
	}
}
