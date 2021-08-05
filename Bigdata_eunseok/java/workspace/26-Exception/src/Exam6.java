class AAA{
	void ex() throws Exception{
		String year2 = "¹»±î¿ä";
		int age = 2021 - Integer.parseInt(year2) + 1;
		System.out.println(age);
	}
}
public class Exam6 {
	public static void main(String[] args) {
		AAA a = new AAA();
		try {
			a.ex();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
