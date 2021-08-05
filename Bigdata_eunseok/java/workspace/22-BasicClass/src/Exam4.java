import java.util.Random;

public class Exam4 {
	public static void main(String[] args) {
		String authNum = "";
		Random random = new Random();
		
		for(int i = 0; i < 5; i++) {
			authNum += random.nextInt(10);
		}
		
		System.out.println(authNum);
	}
}
