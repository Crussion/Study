
public class Exam2 {
	public static void main(String[] args) {
		String email = "student@naver.com";
		String str1 = email.substring(0, email.indexOf("@"));
		String str2 = email.substring(email.indexOf("@") + 1);
		str2 = str2.replace("naver", "java");
		System.out.println(str1);
		System.out.println(str2);
	}
}
