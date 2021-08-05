
public class Exam1 {
	public static void main(String[] args) {
		String year1 = "1990";
		int age1 = 2021 - Integer.parseInt(year1) + 1;
		System.out.println(age1);
		
		String year2 = "¹»±î¿ä?";
		int age2 = 2021 - Integer.parseInt(year2) + 1;
		System.out.println(age2);
	}
}
