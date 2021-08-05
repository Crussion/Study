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
		
		System.out.printf("이름 : %s \n성별 : %s \n나이 : %d세 \n신장 : %.1fcm", name, gender.equals("m") ? "남자":"여자", age, height);
	}
}
