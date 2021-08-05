
public class Exam3 {
	static int random(int min, int max) {
		int num = (int)(Math.random() * (max - min + 1) + min);
		return num;
	}
	public static void main(String[] args) {
		System.out.println(Math.random());
		System.out.println(random(3, 5));
	}
}
