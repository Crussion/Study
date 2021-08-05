class Book{
	String subject;
	String content;
	
	Book(){
		System.out.println("--- 생성자 실행됨 ---");
		subject = "JAVA 입문";
		content = "JAVA는 여러방면에 사용됩니다.";
	}
	void read() {
		System.out.println("--- read() 실행됨 ---");
		System.out.println(subject);
		System.out.println(content);
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Book book = new Book();
		book.read();
	}
}
